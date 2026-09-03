package org.cristian.application;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    public List<Task> tasks = new ArrayList<Task>();

}
