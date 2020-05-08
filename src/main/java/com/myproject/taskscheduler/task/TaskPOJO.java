package com.myproject.taskscheduler.task;

import lombok.Data;

@Data
public class TaskPOJO {

    private long id;

    private String name;

    private String startDate;

    private String endDate;

    private boolean isDone;
}
