var app = require('http').createServer()
var io = module.export.io = require('socket.io')(app)

const PORT = process.env.PORT || 3231

const SocketManager = require('./SocketManger');

io.connection('connection', SocketManager)

app.listen(PORT, ()=>{
  console.log('Connect to port:'+ PORT);
})