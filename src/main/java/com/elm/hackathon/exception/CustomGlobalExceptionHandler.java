package com.elm.hackathon.exception;

import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import com.amazonaws.services.s3.model.AmazonS3Exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class CustomGlobalExceptionHandler {

  @ExceptionHandler(MaxUploadSizeExceededException.class)
  public ResponseEntity<Object> handleError(MaxUploadSizeExceededException e) {

    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", new Date());
    body.put("status", HttpStatus.BAD_REQUEST);
    body.put("message", "File size exceeded 10MB.");

    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({IllegalStateException.class, BadRequestException.class,
      RecordNotFoundException.class})
  public ResponseEntity<Object> handleException(Exception exception) {

    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", new Date());
    body.put("status", HttpStatus.BAD_REQUEST);
    body.put("message", exception.getMessage());

    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(SQLException.class)
  public ResponseEntity<Object> handleException(SQLException sqlException) {

    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", new Date());
    body.put("status", HttpStatus.BAD_REQUEST);
    body.put("message", sqlException.getMessage());
    body.put("key", sqlException.getErrorCode());

    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(AmazonS3Exception.class)
  public ResponseEntity<Object> handleException(AmazonS3Exception exception) {

    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", new Date());
    body.put("status", HttpStatus.BAD_REQUEST);
    body.put("message", exception.getErrorMessage());

    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ForbiddenRequestException.class)
  public ResponseEntity<Object> handleForbiddenException(Exception exception) {
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", new Date());
    body.put("status", HttpStatus.FORBIDDEN);
    body.put("message", exception.getMessage());
    return new ResponseEntity<>(body, HttpStatus.FORBIDDEN);
  }
}
