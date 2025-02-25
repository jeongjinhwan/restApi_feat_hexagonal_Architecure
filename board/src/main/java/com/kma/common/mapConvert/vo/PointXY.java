package com.kma.common.mapConvert.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class PointXY {
  private Double x;
  private Double y;

  public int getIntX() {
    return parseInt(x);
  }
  public int getIntY() {
    return parseInt(y);
  }

  private int parseInt(Double d){
    return d != null ? d.intValue() : 0;
  }
}
