package org.cristian.application;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    public List<Task> tasks = new ArrayList<Task>();

    public TaskService() {
        tasks.add(new Task(1,"task1"));
        tasks.add(new Task(2,"task2"));
        tasks.add(new Task(3,"task3"));
    }
}
