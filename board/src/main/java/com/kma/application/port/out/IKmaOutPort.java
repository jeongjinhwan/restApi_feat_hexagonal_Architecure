package com.kma.application.port.out;

import java.net.SocketTimeoutException;

import org.springframework.stereotype.Service;

import com.kma.adapter.out.vo.ResUltraSrtNcstVO;

/**
 * 기상청 정보 조회. 
 */
@Service
public interface IKmaOutPort {
  /**
   * kma 초단기실황조회
   * @param serviceKey
   * @param numOfRows
   * @param pageNo
   * @param dataType
   * @param baseDate
   * @param baseTime
   * @param nx
   * @param ny
   * @return
   * @throws SocketTimeoutException
   */
  public ResUltraSrtNcstVO getUltraSrtNcst(String serviceKey, String numOfRows, String pageNo, String dataType,
      String baseDate, String baseTime, String nx, String ny) throws SocketTimeoutException;
}
