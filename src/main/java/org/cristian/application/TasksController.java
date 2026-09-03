package org.cristian.application;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TasksController {
    public List<Task> tasks;

    @GetMapping("/api/tasks")
    public List<Task> getTasks(){
       return tasks.stream()
               .toList();
    }
}
