package com.common;

/**
 * zoneId enum으로 변경 합니다.
 */
public enum ZoneIds {
  SEOUL("Asia/Seoul"),
  DARWIN("Australia/Darwin"),
  SYDNEY("Australia/Sydney"),
  BUENOS_AIRES("America/Argentina/Buenos_Aires"),
  CAIRO("Africa/Cairo"),
  ANCHORAGE("America/Anchorage"),
  SAO_PAULO("America/Sao_Paulo"),
  DHAKA("Asia/Dhaka"),
  HARARE("Africa/Harare"),
  ST_JOHNS("America/St_Johns"),
  CHICAGO("America/Chicago"),
  SHANGHAI("Asia/Shanghai"),
  ADDIS_ABABA("Africa/Addis_Ababa"),
  PARIS("Europe/Paris"),
  INDIANAPOLIS("America/Indiana/Indianapolis"),
  KOLKATA("Asia/Kolkata"),
  TOKYO("Asia/Tokyo"),
  APIA("Pacific/Apia"),
  YEREVAN("Asia/Yerevan"),
  AUCKLAND("Pacific/Auckland"),
  KARACHI("Asia/Karachi"),
  PHOENIX("America/Phoenix"),
  PUERTO_RICO("America/Puerto_Rico"),
  LOS_ANGELES("America/Los_Angeles"),
  GUADALCANAL("Pacific/Guadalcanal"),
  HO_CHI_MINH("Asia/Ho_Chi_Minh");

  private final String zoneId;

  ZoneIds(String zoneId) {
    this.zoneId = zoneId;
  }

  public String get() {
    return zoneId;
  }
}
