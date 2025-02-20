package com.kma.common.mapConvert;

import com.kma.common.mapConvert.vo.LocationXY;
import com.kma.common.mapConvert.vo.PointXY;

/**
 * 단기예보 지점 좌표(X,Y)위치와 위경도 간의 전환
 */
public class MapConverter {

  /**
   * 위/경도 를 좌표로 변경.
   * 
   * @param reqLocation
   * @return
   */
  public static PointXY getLocationToPoint(LocationXY reqLocation) {
    double PI, DEGRAD;
    double re, olon, olat, sn, sf, ro;
    double slat1, slat2, ra, theta;
    double lat = reqLocation.getLat();
    double lon = reqLocation.getLon();

    PI = StrictMath.PI;
    DEGRAD = PI / 180.0;
    re = DefMap.Re.getVal() / DefMap.grid.getVal();
    slat1 = DefMap.slat1.getVal() * DEGRAD;
    slat2 = DefMap.slat2.getVal() * DEGRAD;
    olon = DefMap.olon.getVal() * DEGRAD;
    olat = DefMap.olat.getVal() * DEGRAD;

    sn = StrictMath.tan(PI * 0.25 + slat2 * 0.5) / StrictMath.tan(PI * 0.25 + slat1 * 0.5);
    sn = StrictMath.log(StrictMath.cos(slat1) / StrictMath.cos(slat2)) / StrictMath.log(sn);
    sf = StrictMath.tan(PI * 0.25 + slat1 * 0.5);
    sf = StrictMath.pow(sf, sn) * StrictMath.cos(slat1) / sn;
    ro = StrictMath.tan(PI * 0.25 + olat * 0.5);
    ro = re * sf / StrictMath.pow(ro, sn);

    ra = StrictMath.tan(PI * 0.25 + lat * DEGRAD * 0.5);
    ra = re * sf / StrictMath.pow(ra, sn);
    theta = lon * DEGRAD - olon;
    if (theta > PI)
      theta -= 2.0 * PI;
    if (theta < -PI)
      theta += 2.0 * PI;
    theta *= sn;

    double x = (ra * StrictMath.sin(theta)) + DefMap.xo.getVal();
    double y = (ro - ra * StrictMath.cos(theta)) + DefMap.yo.getVal();
    x = (int) (x + 1.5);
    y = (int) (y + 1.5);
    return PointXY.builder().x(x).y(y).build();

  }

  /**
   * 좌표를 위경도로 변경.
   * 
   * @param reqPoint
   * @return
   */
  public static LocationXY getPointToLocation(PointXY reqPoint) {
    double PI, DEGRAD, RADDEG;
    double re, olon, olat, sn, sf, ro;
    double slat1, slat2, alon, alat, xn, yn, ra, theta;
    double x = reqPoint.getX();
    double y = reqPoint.getY();

    x = x - 1;
    y = y - 1;
    PI = StrictMath.asin(1.0) * 2.0;
    DEGRAD = PI / 180.0;
    RADDEG = 180.0 / PI;
    re = DefMap.Re.getVal() / DefMap.grid.getVal();
    slat1 = DefMap.slat1.getVal() * DEGRAD;
    slat2 = DefMap.slat2.getVal() * DEGRAD;
    olon = DefMap.olon.getVal() * DEGRAD;
    olat = DefMap.olat.getVal() * DEGRAD;

    sn = StrictMath.tan(PI * 0.25 + slat2 * 0.5) / StrictMath.tan(PI * 0.25 + slat1 * 0.5);
    sn = StrictMath.log(StrictMath.cos(slat1) / StrictMath.cos(slat2)) / StrictMath.log(sn);
    sf = StrictMath.tan(PI * 0.25 + slat1 * 0.5);
    sf = StrictMath.pow(sf, sn) * StrictMath.cos(slat1) / sn;
    ro = StrictMath.tan(PI * 0.25 + olat * 0.5);
    ro = re * sf / StrictMath.pow(ro, sn);

    xn = x - DefMap.xo.getVal();
    yn = ro - y + DefMap.yo.getVal();
    ra = StrictMath.sqrt(xn * xn + yn * yn);
    if (sn < 0.0)
      ra = -ra;
    alat = StrictMath.pow((re * sf / ra), (1.0 / sn));
    alat = 2.0 * StrictMath.atan(alat) - PI * 0.5;
    if (StrictMath.abs(xn) <= 0.0) {
      theta = 0.0;
    } else {
      if (StrictMath.abs(yn) <= 0.0) {
        theta = PI * 0.5;
        if (xn < 0.0)
          theta = -theta;
      } else
        theta = StrictMath.atan2(xn, yn);
    }
    alon = theta / sn + olon;

    double lat = alat * RADDEG;
    double lon = alon * RADDEG;

    return LocationXY.builder().lon(lon).lat(lat).build();
  }
}
