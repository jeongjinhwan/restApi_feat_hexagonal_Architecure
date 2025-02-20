package com.kma.common.mapConvert.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class LocationXY {
  private double lon;
  private double lat;
}
