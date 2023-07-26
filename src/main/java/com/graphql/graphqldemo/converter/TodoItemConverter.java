package com.graphql.graphqldemo.converter;

import com.graphql.graphqldemo.dto.TodoItemDto;
import com.graphql.graphqldemo.entity.TodoItem;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Component
public class TodoItemConverter implements Converter<TodoItemDto, TodoItem> {

    @Override
    public @NonNull TodoItem convert(TodoItemDto source) {

        TodoItem todoItem = new TodoItem();
        todoItem.setId(source.getId());
        todoItem.setNotes(source.getNotes());
        todoItem.setDueDate(source.getDueDate());
        todoItem.setMarkAsComplete(source.isMarkAsComplete());
        todoItem.setCompletionDate(source.isMarkAsComplete() ? LocalDate.now() : null);

        if (source.getId() > 0) {
            todoItem.setUpdatedAt(LocalDateTime.now());
        } else {
            todoItem.setCreatedAt(LocalDateTime.now());
        }

        return todoItem;
    }
}
