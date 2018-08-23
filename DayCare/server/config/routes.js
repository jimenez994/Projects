const Task = require("../controllers/taskController.js");
// const path = require('path');

module.exports = (app) => {
  app.get("/api/tasks", Task.show);
  app.get("/api/task/:id", Task.findOne);
  app.post("/api/task/create", Task.create);
  app.put("/api/task/update/:id", Task.update);
  app.delete("/api/task/delete/:id", Task.delete);
}