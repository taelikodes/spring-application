package com.example.springapp.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Task {

    @Column
    @Id
    @SequenceGenerator(name = "task_seq", sequenceName = "task_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_seq")
    private int id;
    @Column
    private String title;
    @Column
    private Date start;
    @Column
    private Date end;
    @Column
    private Status status;

    public Task updateValues(Task task) {
        this.title = task.getTitle();
        this.start = task.getStart();
        this.end = task.getEnd();
        return this;
    }

    public Task updateStatus(Status status) {
        this.status = status;
        return this;
    }

}