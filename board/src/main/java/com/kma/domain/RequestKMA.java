package com.kma.domain;

import org.apache.commons.lang3.math.NumberUtils;

import com.common.TimeUtils;
import com.common.exception.BizException;
import com.kma.common.mapConvert.MapConverter;
import com.kma.common.mapConvert.vo.LocationXY;
import com.kma.common.mapConvert.vo.PointXY;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * 요청을 담는 domain
 */
@Slf4j
@Getter
@AllArgsConstructor
@Builder
@ToString
public class RequestKMA {
  /**
   * 현재 일자
   */
  @Default
  private String baseDate = TimeUtils.now();

  /**
   * 현재 시간.
   */
  @Default
  private String baseTime = TimeUtils.nowTime();

  /**
   * x좌표
   */
  private String nx;
  /**
   * y좌표
   */
  private String ny;
  /**
   * 경도
   */
  private String lon;
  /**
   * 위도
   */
  private String lat;

  /**
   * 위도, 경도를 기준으로<br>
   * X,Y 좌표계를 만듭니다.
   */
  public void setXY() {
    if (NumberUtils.isCreatable(lon) && NumberUtils.isCreatable(lat)) {
      LocationXY lxy = LocationXY.builder()
          .lon(Double.parseDouble(lon)).lat(Double.parseDouble(lat)).build();
      // log.debug("{}", lxy.toString());
      PointXY pxy = MapConverter.getLocationToPoint(lxy);
      // log.debug("{}", pxy.toString());

      nx = String.valueOf(pxy.getIntX());
      ny = String.valueOf(pxy.getIntY());
      if (pxy.getIntX() <= 0 && pxy.getIntY() <= 0) {
        log.error("{}", "결과 값이 0 보다 작다.");
        throw new BizException("NUM_ERR_UNDER_ZERO", "MSG10001");
      }
    } else {
      log.error("{}", "입력 값이 없다 이놈아 !!!");
      throw new BizException("NUM_ERR", "MSG10001");
    }
  }
}
