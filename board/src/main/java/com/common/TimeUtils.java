package com.common;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeUtils {
  private final static String YYYY_MM_DD = "yyyyMMdd";
  private final static String HH_MM = "HHmm";

  public static String now() {
    Clock clock = Clock.system(ZoneId.of(ZoneIds.SEOUL.get()));
    return LocalDate.now(clock).format(DateTimeFormatter.ofPattern(YYYY_MM_DD));
  }

  public static String nowTime() {
    Clock clock = Clock.system(ZoneId.of(ZoneIds.SEOUL.get()));
    return LocalDateTime.now(clock).format(DateTimeFormatter.ofPattern(HH_MM));
  }
}
