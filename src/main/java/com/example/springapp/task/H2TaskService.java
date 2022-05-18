package com.example.springapp.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class H2TaskService implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public H2TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Task task, int taskID) throws InstanceNotFoundException {
        Optional<Task> databaseTask = taskRepository.findById(taskID);
        if (databaseTask.isEmpty()) {
            throw new InstanceNotFoundException();
        }

        return taskRepository.save(databaseTask.get().updateValues(task));
    }

    @Override
    public List<Task> exhibitTasks() {
        return taskRepository.findAll();
    }
}
