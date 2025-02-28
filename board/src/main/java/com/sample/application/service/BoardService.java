package com.sample.application.service;

import java.net.SocketTimeoutException;
import java.time.zone.ZoneRulesException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.common.TimeUtils;
import com.kma.adapter.out.vo.ResUltraSrtNcstVO;
import com.sample.application.port.in.IBoardUseCase;
import com.sample.application.port.out.IBoardOutPort;
import com.sample.domain.Board;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService implements IBoardUseCase {

  @Value("${auth.kma.deckey}")
  String serviceKey;

  private final IBoardOutPort boardOutPort;

  @Override
  public List<Board> getList(String boardId) {
    List<Board> list = boardOutPort.getList(boardId);
    return list;
    // throw new UnsupportedOperationException("Unimplemented method 'register'");
  }

  @Override
  public int register(Board board) {
    // boardOutPort.register(board);
    throw new UnsupportedOperationException("Unimplemented method 'register'");
  }

  @Override
  public Board update(Board board) {
    // boardOutPort.update(board);
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public int delete(Board board) {
    // boardOutPort.delete(board);
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public int create() {
    // boardOutPort.create();
    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }

  @Override
  public Board getDetail(String boardId) throws ZoneRulesException, SocketTimeoutException {

    String baseDate = TimeUtils.now();
    
    log.debug("--------------------------------------------------------");
    log.debug("baseDate:{}", baseDate);
    log.debug("--------------------------------------------------------");
    String numOfRows = "10";
    String pageNo = "1";
    String dataType = "JSON";
    String baseTime = "0500";
    String nx = "55";
    String ny = "127";

    ResUltraSrtNcstVO resUltraSrtNcstVO = null;
    // feign 호출 결과 확인.
    try {
      resUltraSrtNcstVO = boardOutPort.getUltraSrtNcst(serviceKey, numOfRows, pageNo, dataType,
          baseDate, baseTime, nx, ny);
    } catch (SocketTimeoutException se) {
      se.printStackTrace();
      resUltraSrtNcstVO = new ResUltraSrtNcstVO();
    }

    return Board.builder().boardNo(0).contents(resUltraSrtNcstVO.toString()).author("").build();
  }

}
