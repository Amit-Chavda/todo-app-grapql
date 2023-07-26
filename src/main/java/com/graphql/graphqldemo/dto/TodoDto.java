package com.graphql.graphqldemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {
    private Long id;
    private String title;
    private boolean markAsComplete = false;

    private List<TodoItemDto> items = new ArrayList<>();
}
