package com.kma.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ItemKMA {
  private String category;
  private String unitNm;
  private String obsrValue;
}
