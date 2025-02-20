package com.kma.domain;

import org.springframework.beans.factory.annotation.Value;

import com.common.TimeUtils;
import com.kma.common.mapConvert.MapConverter;
import com.kma.common.mapConvert.vo.LocationXY;
import com.kma.common.mapConvert.vo.PointXY;

import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class KMA {
  @Value("${auth.kma.deckey}")
  private String serviceKey;

  @Default
  private String baseDate = TimeUtils.now();
  @Default
  private String baseTime = "0500";
  private String nx;
  private String ny;

  @Default
  private String dataType = "JSON";
  @Default
  private String numOfRows = "10";
  @Default
  private String pageNo = "1";

  public void setLocationToPoint(LocationXY reqLocation) {
    PointXY pxy = MapConverter.getLocationToPoint(reqLocation);
    nx = pxy.getX().toString();
    nx = pxy.getY().toString();
  }

}
