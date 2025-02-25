package com.common.exception.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrResponse {
  private String errorCode;
  private String errorMessage;
}
