package org.cristian.application;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TasksController {
    private final TaskService service;
    public TasksController(TaskService service){
        this.service=service;
    }

    @GetMapping("/api/tasks")
    public List<Task> getTasks(){
       return service.getTasks();
    }

    @GetMapping("/api/tasks/{id}")
    public ResponseEntity<Task> getTask(@PathVariable int id){
       var t = service.getTask(id);
       if(t.isEmpty())
           return ResponseEntity.notFound().build();
       else
           return ResponseEntity.ok(t.get());

    }

    @PostMapping("/api/tasks")
    public Task addTask(@RequestBody Task t) {
       return service.addTask(t);
    }


    @DeleteMapping("/api/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable int id){
        if(service.deleteTask(id))
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.notFound().build();
    }

}
