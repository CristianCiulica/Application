package org.cristian.application;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class TasksController {
    public List<Task> tasks=new ArrayList<Task>();

    public TasksController() {
        tasks.add(new Task(1,"task1"));
        tasks.add(new Task(2,"task2"));
        tasks.add(new Task(3,"task3"));
    }

    @GetMapping("/api/tasks")
    public List<Task> getTasks(){
       return tasks;
    }
    @GetMapping("/api/tasks/{id}")
    public Task getTask(@PathVariable int id){
        return tasks.get(id);
    }

    @PostMapping("/api/tasks")
    public Task addTask(@RequestBody Task t) {
        tasks.add(t);
        return t;
    }
}
