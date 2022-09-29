package com.elm.hackathon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class ForbiddenRequestException extends RuntimeException {

  public ForbiddenRequestException() {
    super();
  }

  public ForbiddenRequestException(String message, Throwable cause) {
    super(message, cause);
  }

  public ForbiddenRequestException(String message) {
    super(message);
  }

  public ForbiddenRequestException(Throwable cause) {
    super(cause);
  }
}
