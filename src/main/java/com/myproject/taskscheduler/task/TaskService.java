package com.myproject.taskscheduler.task;

import java.util.List;

public interface TaskService {

    List<Task> findAll();

    boolean saveTask(Task task);

    void saveAllTask(List<Task> tasks);


}
