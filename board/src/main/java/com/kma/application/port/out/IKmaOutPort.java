package com.kma.application.port.out;

import java.net.SocketTimeoutException;

import org.springframework.stereotype.Service;

import com.kma.adapter.out.vo.ResUltraSrtNcstVO;
import com.kma.domain.RequestKMA;

/**
 * 기상청 정보 조회.
 */
@Service
public interface IKmaOutPort {

  /**
   * kma 초단기실황조회
   * 
   * @param reqKma
   * @return
   * @throws SocketTimeoutException
   */
  public ResUltraSrtNcstVO getUltraSrtNcst(RequestKMA reqKma) throws SocketTimeoutException;
}
