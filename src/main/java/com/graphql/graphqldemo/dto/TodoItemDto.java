package com.graphql.graphqldemo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoItemDto {

    private long id;
    private String notes;

    @JsonFormat(pattern = "dd-MMM-yyyy")
    private LocalDate dueDate;
    private boolean markAsComplete = false;

    @JsonFormat(pattern = "dd-MMM-yyyy")
    private LocalDate completionDate;

    @JsonFormat(pattern = "dd-MMM-yyyy HH:mm")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "dd-MMM-yyyy HH:mm")
    private LocalDateTime updatedAt;

}
