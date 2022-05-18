package com.example.springapp.task;

import javax.management.InstanceNotFoundException;
import java.util.List;

public interface TaskService {
    Task createTask(Task task);

    Task updateTask(Task task, int taskID) throws InstanceNotFoundException;

    List<Task> exhibitTasks();

    Task updateTaskStatus(Status status, int taskID) throws InstanceNotFoundException;
}
