package com.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BizException extends RuntimeException {
  /**
   * 오류 코드
   */
  private String errCode;
  /**
   * 메세지 코드.
   */
  private String msgCode;
}
