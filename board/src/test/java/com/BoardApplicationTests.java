package com;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.common.TimeUtils;
import com.common.ZoneIds;
import com.kma.common.mapConvert.MapConverter;
import com.kma.common.mapConvert.vo.LocationXY;
import com.kma.common.mapConvert.vo.PointXY;

@ExtendWith(MockitoExtension.class)
// @SpringBootTest
class BoardApplicationTests {

  @Test
  void contextLoads() {
    // time_test(); // ok 
    // mapConvert_test(); // ok
  }

  private void mapConvert_test() {
    LocationXY lxy = LocationXY.builder().lon(126.929810).lat(37.488201).build();
    PointXY pxy = MapConverter.getLocationToPoint(lxy);
    System.out.println("TimeUtils2.now() :" + pxy.toString());
    // 출력결과)lon.= 126.929810, lat.= 37.488201 ---> X = 59, Y = 125
    
    pxy = PointXY.builder().y(125d).x(59d).build();
    lxy = MapConverter.getPointToLocation(pxy);
    System.out.println("TimeUtils2.now() :" + lxy.toString());
    // 출력결과)X = 59, Y = 125 --->lon.= 126.929810, lat.= 37.488201
  }

  private void time_test() {
    System.out.println("------------------");
    System.out.println("ZoneIds.SEOUL.get() :" + ZoneIds.SEOUL.get());
    System.out.println("------------------");
    System.out.println("TimeUtils2.now() :" + TimeUtils.now());
    System.out.println("------------------");
  }

}
