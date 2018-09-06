const mongoose = require('mongoose');
const fs = require('fs');

mongoose.connect("mongodb://zeus:test12345@ds247852.mlab.com:47852/daycare", { useNewUrlParser: true });
// mongoose.connect("mongodb://localhost/daycare1", { useNewUrlParser: true });
mongoose.Promise = global.Promise;

var models_path = __dirname + "/../models";
fs.readdirSync(models_path).forEach((file) => {
  if(file.includes('.js')){
    console.log("loading" + file + "...");
    require(models_path + "/" + file);
  }
})