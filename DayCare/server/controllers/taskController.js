const mongoose = require('mongoose');
const Task = mongoose.model('task');

module.exports = {
  show(req, res){
    Task.find({}, (err, tasks) => {
      if(err){
        return res.json(err);
      }else{
        return res.json(tasks.reverse());
      }
    })
  }
}