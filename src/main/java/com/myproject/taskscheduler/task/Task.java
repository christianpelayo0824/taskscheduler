package com.myproject.taskscheduler.task;

import lombok.Data;

import javax.persistence.*;

/**
 * This Entity is the structure of the Task Object <br>
 * that reflect from/to Database.
 *
 * @author Christian Pelayo.
 * Date: 02 Apr 2020
 */
@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "startDate")
    private String startDate;

    @Column(name = "endDate")
    private String endDate;

    @Column(name = "isDone")
    private boolean isDone;
}
