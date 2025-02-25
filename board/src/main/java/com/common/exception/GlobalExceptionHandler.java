package com.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.common.exception.domain.ErrResponse;

/**
 * 오류 핸들러.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

  /**
   * 비즈니스 Exception 처리.
   * @param ex
   * @return
   */
  @ExceptionHandler(BizException.class)
  public ResponseEntity<ErrResponse> handleBizExceptions(BizException ex) {
    ErrResponse errorResponse = new ErrResponse(ex.getErrCode(), ex.getMsgCode());
    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  /**
   * 그 외 오류 처리.
   * @param ex
   * @return
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrResponse> handleAllExceptions(Exception ex) {
    ErrResponse errorResponse = new ErrResponse(ex.getMessage(), "err-sample");
    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
