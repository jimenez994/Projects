const mongoose = require('mongoose');

const TaskSchema = new mongoose.Schema({
  title : {
    type: String,
    minlength:[1, "Sorry title cannot be empty"]
  },
  description : {
    type: String,
    minlength:[1, "Sorry description cannot be empty"]
  }
}, {timestamps: true});

const Task = mongoose.model("task", TaskSchema);
