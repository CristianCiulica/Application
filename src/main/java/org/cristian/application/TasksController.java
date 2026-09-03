package org.cristian.application;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
