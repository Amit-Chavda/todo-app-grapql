package com.graphql.graphqldemo.repository;

import com.graphql.graphqldemo.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem,Long> {

}
