package com.kma.adapter.in.web;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.kma.adapter.in.dto.ResUltraSrtNcstDTO;
import com.kma.application.port.in.IKmaUseCase;
import com.kma.domain.RequestKMA;
import com.kma.domain.ResponseKMA;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class KmaController implements KmaControllerApi {
  private final IKmaUseCase kmaUseCase;
  private final ModelMapper modelMapper;

  @Override
  public ResponseEntity<ResUltraSrtNcstDTO> getUltraSrtNcst(String lat, String lon) throws Exception {

    RequestKMA reqKMA = RequestKMA.builder().lon(lon).lat(lat).build();
    ResponseKMA resKMA = kmaUseCase.getUltraSrtNcst(reqKMA);
    ResUltraSrtNcstDTO resUltraSrtNcstDTO = modelMapper.map(resKMA, ResUltraSrtNcstDTO.class);
    return ResponseEntity.ok(resUltraSrtNcstDTO);
  }
}
