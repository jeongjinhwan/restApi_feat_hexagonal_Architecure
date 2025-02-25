package com.kma.application.service;

import java.net.SocketTimeoutException;
import java.time.zone.ZoneRulesException;

import org.springframework.stereotype.Service;

import com.common.exception.BizException;
import com.kma.adapter.out.vo.ResUltraSrtNcstVO;
import com.kma.application.port.in.IKmaUseCase;
import com.kma.application.port.out.IKmaOutPort;
import com.kma.common.CommonCodeKMA;
import com.kma.domain.ItemKMA;
import com.kma.domain.RequestKMA;
import com.kma.domain.ResponseKMA;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 기상청 정보 조회.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class KmaService implements IKmaUseCase {
  private final IKmaOutPort kmaOutPort;

  public ResponseKMA getUltraSrtNcst(RequestKMA reqKma) throws ZoneRulesException, SocketTimeoutException {

    reqKma.setXY();
    ResUltraSrtNcstVO resUltraSrtNcstVO = kmaOutPort.getUltraSrtNcst(reqKma);

    ResponseKMA resKma = new ResponseKMA(resUltraSrtNcstVO);
    if (!resKma.isSuccessfulResponse()) {
      log.error("[getUltraSrtNcst]request:{},response:{}", reqKma.toString(), resUltraSrtNcstVO.toString());
      throw new BizException("KMA_ERR", "MSG0001"); // 출력 데이터 없습니다.
    }

    resUltraSrtNcstVO.getResponse().getBody().getItems().getItem().forEach(e -> {

      CommonCodeKMA ccKMA = CommonCodeKMA.getByCode(e.getCategory().getValue());
      resKma.addItem(
          ItemKMA.builder()
              .category(ccKMA.getItmNm())
              .unitNm(ccKMA.getUnitNm())
              .obsrValue(e.getObsrValue())
              .build());
    });

    return resKma;
  }
}
