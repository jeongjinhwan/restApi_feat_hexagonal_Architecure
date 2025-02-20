package com.sample.adapter.in.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.adapter.in.dto.BoardDTO;
import com.sample.application.port.in.IBoardUseCase;
import com.sample.domain.Board;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardController implements BoardControllerApi {

  private final IBoardUseCase boardUseCase;
  private final ObjectMapper objectMapper;

  @GetMapping("/hi")
  public String getHi(@RequestParam String param) {
    return "hi~";
  }

  @GetMapping("/list")
  public ResponseEntity<List<Board>> getList() {
    return ResponseEntity.ok(boardUseCase.getList("0"));
  }

  @Override
  public ResponseEntity<Object> createBoard(BoardDTO boardDTO) throws Exception {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  @Override
  public ResponseEntity<BoardDTO> getDetail(Integer boardNo) throws Exception {
    Board getBoard = boardUseCase.getDetail("0");
    BoardDTO getBoardDTO = objectMapper.convertValue(getBoard, BoardDTO.class);
    return ResponseEntity.ok(getBoardDTO);
  }

}
