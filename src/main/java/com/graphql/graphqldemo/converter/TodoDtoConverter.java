package com.graphql.graphqldemo.converter;

import com.graphql.graphqldemo.dto.TodoDto;
import com.graphql.graphqldemo.dto.TodoItemDto;
import com.graphql.graphqldemo.entity.Todo;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class TodoDtoConverter implements Converter<Todo, TodoDto> {

    private final TodoItemDtoConverter todoItemDtoConverter;

    @Override
    public @NonNull TodoDto convert(Todo source) {
        List<TodoItemDto> todoItems = source.getItems().stream().map(todoItemDtoConverter::convert).toList();
        return new TodoDto(source.getId(), source.getTitle(), source.isMarkAsComplete(), todoItems);
    }
}
