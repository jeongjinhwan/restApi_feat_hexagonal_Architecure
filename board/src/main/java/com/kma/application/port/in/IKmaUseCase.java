package com.kma.application.port.in;

import java.net.SocketTimeoutException;
import java.time.zone.ZoneRulesException;

import org.springframework.stereotype.Service;

import com.kma.domain.RequestKMA;
import com.kma.domain.ResponseKMA;

/**
 * 기상청 정보 조회.
 */
@Service
public interface IKmaUseCase {
  /**
   * 초 단위 예보 조회.
   * 
   * @param reqKma
   * @return
   * @throws ZoneRulesException
   * @throws SocketTimeoutException
   */
  public ResponseKMA getUltraSrtNcst(RequestKMA reqKma) throws ZoneRulesException, SocketTimeoutException;
}
