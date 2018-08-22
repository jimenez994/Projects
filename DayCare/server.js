const express = require('express');
const bodyparser = require('body-parser');
const session = require('express-session');
const port = 8000;
const app = express();

app.use(bodyparser.json());
app.use(session({secret:'RealMadrid'}))
app.use(express.static(__dirname + 'client/dist'));

require("./server/config/mongoose");
require("./server/config/routes")(app);

app.listen(port,() => {
  console.log("linsting in port "+ port);
})