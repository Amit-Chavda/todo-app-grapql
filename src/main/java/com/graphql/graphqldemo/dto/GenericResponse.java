package com.graphql.graphqldemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericResponse {
    private boolean success;
    private String message;
    private Object data;
    private int code;
    private LocalDateTime timestamp;
}