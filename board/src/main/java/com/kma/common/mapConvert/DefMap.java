package com.kma.common.mapConvert;

public enum DefMap {
  Re(6371.00877), /* 사용할 지구반경 [ km ] */
  grid(5.0), /* 격자간격 [ km ] */
  slat1(30.0), /* 표준위도 [degree] */
  slat2(60.0), /* 표준위도 [degree] */
  olon(126.0), /* 기준점의 경도 [degree] */
  olat(38.0), /* 기준점의 위도 [degree] */
  xo(getDivGrid(210)), /* 기준점의 X좌표 [격자거리] */
  yo(getDivGrid(675)); /* 기준점의 Y좌표 [격자거리] */

  private double d;

  DefMap(double d) {
    this.d = d;
  }

  public double getVal() {
    return d;
  }

  public static double getDivGrid(double d) {
    return d / grid.getVal();
  }
}
