package org.cristian.application;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TasksController {

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
    public ResponseEntity<Task> getTask(@PathVariable int id){
       var t = tasks.stream()
               .filter(task -> task.getId()==id)
               .findFirst();
       if(t.isEmpty())
           return ResponseEntity.notFound().build();
       else
           return ResponseEntity.ok(t.get());

    }
    @PostMapping("/api/tasks")
    public Task addTask(@RequestBody Task t) {
        tasks.add(t);
        return t;
    }

    @DeleteMapping("/api/tasks/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable int id){
        if(tasks.removeIf(task -> task.getId()==id))
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.notFound().build();


    }

}
