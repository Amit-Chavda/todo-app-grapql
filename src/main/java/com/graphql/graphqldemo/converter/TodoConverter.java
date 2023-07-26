package com.graphql.graphqldemo.converter;

import com.graphql.graphqldemo.dto.TodoDto;
import com.graphql.graphqldemo.entity.Todo;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;


@Component
public class TodoConverter implements Converter<TodoDto, Todo> {
    @Override
    public @NonNull Todo convert(TodoDto source) {
        return new Todo(0, source.getTitle(), source.isMarkAsComplete(), source.isMarkAsComplete() ? LocalDate.now() : null, Collections.emptyList());
    }
}
