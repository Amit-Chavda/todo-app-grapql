package com.graphql.graphqldemo.exception;

import com.graphql.graphqldemo.dto.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<GenericResponse> handleResourceNotFoundException(ResourceNotFoundException exception) {
        GenericResponse genericResponse = new GenericResponse(false, exception.getMessage(), "", HttpStatus.NOT_FOUND.value(), LocalDateTime.now());
        log.error("handling ResourceNotFoundException...");
        log.error(exception.getMessage());
        return new ResponseEntity<>(genericResponse, HttpStatus.NOT_FOUND);
    }


  
    @ExceptionHandler(value = IllegalStateException.class)
    public final ResponseEntity<GenericResponse> handleIllegalStateException(IllegalStateException exception) {
        GenericResponse genericResponse = new GenericResponse(false, exception.getMessage(), "", HttpStatus.CONFLICT.value(), LocalDateTime.now());
        log.error("handling IllegalStateException...");
        log.error(exception.getMessage());
        return new ResponseEntity<>(genericResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = IOException.class)
    public final ResponseEntity<GenericResponse> handleIOException(IOException exception) {
        GenericResponse genericResponse = new GenericResponse(false, exception.getMessage(), "", HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now());
        log.error("handling IOException...");
        log.error(exception.getMessage());
        return new ResponseEntity<>(genericResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(value = URISyntaxException.class)
    public final ResponseEntity<GenericResponse> handleURISyntaxException(URISyntaxException exception) {
        GenericResponse genericResponse = new GenericResponse(false, exception.getMessage(), "", HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now());
        log.error("handling URISyntaxException...");
        log.error(exception.getMessage());
        return new ResponseEntity<>(genericResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = MaxUploadSizeExceededException.class)
    public final ResponseEntity<GenericResponse> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException exception) {
        GenericResponse genericResponse = new GenericResponse(false, exception.getMessage(), "", HttpStatus.PAYLOAD_TOO_LARGE.value(), LocalDateTime.now());
        log.error("handling MaxUploadSizeExceededException...");
        log.error(exception.getMessage());
        return new ResponseEntity<>(genericResponse, HttpStatus.PAYLOAD_TOO_LARGE);
    }


    @ExceptionHandler(value = IllegalArgumentException.class)
    public final ResponseEntity<GenericResponse> handleIllegalArgumentException(IllegalArgumentException exception) {
        GenericResponse genericResponse = new GenericResponse(false, exception.getMessage(), "", HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
        log.error("handling IllegalArgumentException...");
        log.error(exception.getMessage());
        return new ResponseEntity<>(genericResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = ParseException.class)
    public final ResponseEntity<GenericResponse> handleParseException(ParseException exception) {
        GenericResponse genericResponse = new GenericResponse(false, exception.getMessage(), "", HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
        log.error("handling ParseException...");
        log.error(exception.getMessage());
        return new ResponseEntity<>(genericResponse, HttpStatus.BAD_REQUEST);
    }




}
