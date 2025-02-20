package com.kma.application.service;

import java.net.SocketTimeoutException;

import org.springframework.stereotype.Service;

import com.kma.adapter.in.dto.ResUltraSrtNcstVO;
import com.kma.application.port.in.IKmaUseCase;
import com.kma.application.port.out.IKmaOutPort;
import com.kma.domain.KMA;

import lombok.RequiredArgsConstructor;

/**
 * 기상청 정보 조회.
 */
@Service
@RequiredArgsConstructor
public class KmaService implements IKmaUseCase {

  private final IKmaOutPort kmaOutPort;

  public ResUltraSrtNcstVO getUltraSrtNcst(KMA reqKma) throws SocketTimeoutException {

    ResUltraSrtNcstVO resUltraSrtNcstVO = null;
    // try {
    //   resUltraSrtNcstVO = kmaOutPort.getUltraSrtNcst(reqKma.getServiceKey(), reqKma.getNumOfRows(), reqKma.getPageNo(),
    //       reqKma.getDataType(), reqKma.getBaseDate(),
    //       reqKma.getBaseTime(), reqKma.getNx(), reqKma.getNy());

    // } catch (SocketTimeoutException se) {
    //   se.printStackTrace();
    //   resUltraSrtNcstVO = new ResUltraSrtNcstVO();
    // }

    return null;

    // return
    // Board.builder().boardNo(0).contents(resUltraSrtNcstVO.toString()).author("").build();
  }

}
