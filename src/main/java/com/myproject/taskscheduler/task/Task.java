package com.myproject.taskscheduler.task;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * This Entity is the structure of the Task Object <br>
 * that reflect from/to Database.
 *
 * @author Christian Pelayo.
 * @since 2020-04-02
 */
@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "startDate")
    private String startDate;

    @NotNull
    @Column(name = "endDate")
    private String endDate;

    @Column(name = "isDone")
    private boolean isDone;
}
