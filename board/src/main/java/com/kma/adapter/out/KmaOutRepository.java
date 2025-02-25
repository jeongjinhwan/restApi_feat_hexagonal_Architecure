package com.kma.adapter.out;

import java.net.SocketTimeoutException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.kma.adapter.out.vo.ResUltraSrtNcstVO;
import com.kma.adapter.out.web.KmaApiClient;
import com.kma.application.port.out.IKmaOutPort;
import com.kma.domain.RequestKMA;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class KmaOutRepository implements IKmaOutPort {

  @Value("${AUTH_KMA_DECKEY}")
  private String serviceKey;
  private static final String dataType = "JSON";

  private final KmaApiClient kmaClient;

  @Override
  public ResUltraSrtNcstVO getUltraSrtNcst(RequestKMA reqKma) throws SocketTimeoutException {
    return kmaClient.getUltraSrtNcst(serviceKey, "0", "0", dataType,
        reqKma.getBaseDate(), reqKma.getBaseTime(), reqKma.getNx(), reqKma.getNy()).getBody();
  }

}
