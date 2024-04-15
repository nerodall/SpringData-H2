package ru.gb.SpringDataH2.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.SpringDataH2.model.Task;
import ru.gb.SpringDataH2.model.TaskStatus;
import ru.gb.SpringDataH2.service.TaskService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class Controller {
    @Autowired
    private final TaskService taskService;

    @GetMapping("getAll")
    public List<Task> getAllTasks(){
        return taskService.getAllTask();
    }

    @PostMapping("create")
    public String createTask(@RequestBody Task task){
      return taskService.createTask(task).toString();
    }

    @GetMapping("status/{status}")
    public List<Task> getByStatus(@PathVariable TaskStatus status){
        return taskService.findTaskByStatus(status);
    }

    @PutMapping("update/{id}")
    public void updateById(@PathVariable Long id,@RequestBody Task task){
         taskService.updateTask(id,task);
    }

    @PostMapping("delete/{id}")
    public String deleteById(@PathVariable Long id){
        taskService.deleteTask(id);
        return "task deleted";
    }
}
