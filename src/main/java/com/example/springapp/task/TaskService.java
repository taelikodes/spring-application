package com.example.springapp.task;

import javax.management.InstanceNotFoundException;

public interface TaskService {
    Task createTask(Task task);
    Task updateTask(Task task, int taskID) throws InstanceNotFoundException;
}
