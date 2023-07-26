package com.graphql.graphqldemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "todo_items")
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String notes;
    private LocalDate dueDate;
    private boolean markAsComplete;
    private LocalDate completionDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne(cascade ={ CascadeType.PERSIST,CascadeType.MERGE}, targetEntity = Todo.class)
    private Todo todo = new Todo();
}
