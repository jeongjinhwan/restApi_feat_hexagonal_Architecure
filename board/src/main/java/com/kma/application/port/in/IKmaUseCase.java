package com.kma.application.port.in;

import java.net.SocketTimeoutException;
import java.time.zone.ZoneRulesException;

import org.springframework.stereotype.Service;

import com.kma.adapter.in.dto.ResUltraSrtNcstVO;
import com.kma.domain.KMA;

/**
 * 기상청 정보 조회.
 */
@Service
public interface IKmaUseCase {
  /**
   * 초 단위 예보 조회.
   * @param kmaReq
   * @return
   * @throws ZoneRulesException
   * @throws SocketTimeoutException
   */
  public ResUltraSrtNcstVO getUltraSrtNcst(KMA kmaReq) throws SocketTimeoutException;
}
