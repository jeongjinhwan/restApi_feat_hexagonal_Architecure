package com.kma.adapter.in.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kma.adapter.in.dto.ResUltraSrtNcstVO;
import com.kma.application.port.in.IKmaUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class KmaController implements KmaControllerApi {

  private IKmaUseCase kmaUseCase;
  private final ObjectMapper objectMapper;

  @Override
  public ResponseEntity<ResUltraSrtNcstVO> getUltraSrtNcst(String lon, String lat) throws Exception {
    
    ResUltraSrtNcstVO resUltraSrtNcstVO = kmaUseCase.getUltraSrtNcst(null);
    return ResponseEntity.ok(resUltraSrtNcstVO);
  }

}
