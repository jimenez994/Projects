const mongoose = require('mongoose');
const Task = mongoose.model('task');

module.exports = {
  show(req, res){
    Task.find()
      .sort({createdAt: -1})
      .then(tasks => res.json(tasks))
      .catch(err => res.status(404).json({ noTasksFound: "Sorry no tasks found"}))
  },
  findOne(req, res){
    Task.findById(req.params.id)
      .then(task => res.json(task))
      .catch(err => res.status(404).json({ noTaskFound:"Sorry task could not be found"}))
  },
  create(req, res){
    Task.create(req.body)
      .then(task => res.json(task))
      .catch(err => res.status(401).json({ errorCreating: "Sorry task could not be created"}))
  },
  update(req, res){
    Task.findByIdAndUpdate(req.params.id, req.body)
      .then(result => res.json({ taskUpdated: "Successfully updated" }))
      .catch(err => res.status(401).json({ errorUpdating: "Sorry something went wrong while trying to update the task" }))
  },
  delete(req, res){
    Task.findByIdAndRemove(req.params.id)
      .then(result => res.json({result: "Successfully deleted task"}))
      .catch(err => res.status(404).json({ errorDeleting: "No task found"}))
  }
}