package com.example.springboot2_essentials.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice // Qual a diferença pro @RestControllerAdvice?
public class RestExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> HandlerBadRequestException(BadRequestException e){
        return new ResponseEntity<>(
                BadRequestExceptionDetails.builder()
                        .title("Bad Request Exception, Check the Documentation")
                        .status(HttpStatus.BAD_REQUEST.value())
                        .details(e.getMessage())
                        .developerMessage(e.getClass().getName())
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.BAD_REQUEST
        );
    }
}
