package org.cristian.application;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    public List<Task> tasks = new ArrayList<Task>();

    public TaskService() {
        tasks.add(new Task(1,"task1"));
        tasks.add(new Task(2,"task2"));
        tasks.add(new Task(3,"task3"));
    }

    public List<Task> getTasks(){
        return tasks;
    }

    public Task addTask(Task task){
        tasks.add(task);
        return task;
    }

    public boolean deleteTask(int id){
        return tasks.removeIf(task -> task.getId()==id);

    }

    public Optional<Task> getTask(int id){
        var t = tasks.stream()
                .filter(task -> task.getId()==id)
                .findFirst();
        return t;
    }
}
