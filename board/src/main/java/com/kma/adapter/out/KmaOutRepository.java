package com.kma.adapter.out;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.kma.adapter.out.vo.ResUltraSrtNcstVO;
import com.kma.adapter.out.web.KmaApiClient;
import com.kma.application.port.out.IKmaOutPort;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class KmaOutRepository implements IKmaOutPort {

  private final KmaApiClient kmaClient;

  @Override
  public ResUltraSrtNcstVO getUltraSrtNcst(String serviceKey, String numOfRows, String pageNo, String dataType,
      String baseDate, String baseTime, String nx, String ny) {

    ResponseEntity<ResUltraSrtNcstVO> getUltraSrtNcst = kmaClient.getUltraSrtNcst(serviceKey, numOfRows, pageNo,
        dataType, baseDate, baseTime, nx, ny);

    return getUltraSrtNcst.getBody();
  }

}
