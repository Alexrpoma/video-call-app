package com.example.videocallapp.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class ApiExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ApiError> handleException(
      ResourceNotFoundException notFoundException,
      HttpServletRequest request
  ) {
    ApiError apiError = ApiError.builder()
        .path(request.getRequestURI())
        .message(notFoundException.getMessage())
        .statusCode(HttpStatus.NOT_FOUND.value())
        .localDateTime(getTime())
        .build();
    return ResponseEntity.badRequest().body(apiError);
  }

  private String getTime() {
    return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
  }
}
