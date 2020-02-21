package io.javabrains.jwt.ErrorsHandlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserNotFoundException extends RuntimeException {

  Logger logger = LoggerFactory.getLogger(UserNotFoundException.class);

  public UserNotFoundException(String exception) {
    super(exception);
    logger.error(exception);
  }

}