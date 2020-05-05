package com.myproject.taskscheduler.service.task;

import com.myproject.taskscheduler.model.Task;

import java.util.List;

public interface TaskService {

    List<Task> findAll();

    boolean saveTask(Task task);

    void saveAllTask(List<Task> tasks);


}
