package com.myproject.taskscheduler.task;

import java.util.List;

public interface TaskService {

    List<Task> findAll();

    boolean saveTask(TaskPOJO taskPOJO);

    void saveAllTask(List<Task> tasks);


}
