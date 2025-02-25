package com.kma.common;

import lombok.Getter;

@Getter
public enum CommonCodeKMA {
  T1H("기온", "℃", 10),
  RN1("1시간 강수량", "mm", 8),
  UUU("동서바람성분", "m/s", 12),
  VVV("남북바람성분", "m/s", 12),
  REH("습도", "%", 8),
  PTY("강수형태", "코드값", 4),
  VEC("풍향", "deg", 10),
  WSD("풍속", "m/s", 10);

  private String itmNm;
  private String unitNm;
  private int bitCnt;

  CommonCodeKMA(String itmNm, String unitNm, int bitCnt) {
    this.itmNm = itmNm;
    this.unitNm = unitNm;
    this.bitCnt = bitCnt;
  }

  public static CommonCodeKMA getByCode(String code) {
    for (CommonCodeKMA value : CommonCodeKMA.values()) {
      if (value.name().equalsIgnoreCase(code)) {
        return value;
      }
    }
    return null;
  }
}
