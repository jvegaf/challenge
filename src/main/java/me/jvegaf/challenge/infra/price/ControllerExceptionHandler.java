package me.jvegaf.challenge.infra.price;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import me.jvegaf.challenge.application.price.ApiError;
import me.jvegaf.challenge.domain.price.ManyPricesFound;
import me.jvegaf.challenge.domain.price.PriceNotFound;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {
  private final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

  @ExceptionHandler(RuntimeException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  protected ResponseEntity<Object> handleRuntimeException(RuntimeException ex) {
    logger.error("ERROR: " + ex);
    return new ResponseEntity<>(
        new ApiError(Collections.singletonList(ex.getMessage()),
        HttpStatus.INTERNAL_SERVER_ERROR.value()),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(ManyPricesFound.class)
  @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
  public ResponseEntity<ApiError> handleManyPricesFound(ManyPricesFound ex) {
    logger.error("ERROR: " + ex);
    return new ResponseEntity<>(
        new ApiError(Collections.singletonList(ex.getMessage()),
        HttpStatus.EXPECTATION_FAILED.value()),
      HttpStatus.EXPECTATION_FAILED);
  }

  @ExceptionHandler(PriceNotFound.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  protected ResponseEntity<ApiError> handlePriceNotFound(PriceNotFound ex) {
    logger.error("ERROR: " + ex);
    return new ResponseEntity<>(
        new ApiError(Collections.singletonList(ex.getMessage()),
        HttpStatus.NOT_FOUND.value()),
        HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  protected ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
    logger.error("ERROR: " + ex);
    List<String> errors = ex.getBindingResult().getFieldErrors()
        .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());

    return new ResponseEntity<>(new ApiError(errors,
        HttpStatus.BAD_REQUEST.value()),
        HttpStatus.BAD_REQUEST);
  }

}
