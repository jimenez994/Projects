const Task = require("../controllers/taskController.js");
// const path = require('path');

module.exports = (app) => {
  app.get("/tasks", Task.show);
}