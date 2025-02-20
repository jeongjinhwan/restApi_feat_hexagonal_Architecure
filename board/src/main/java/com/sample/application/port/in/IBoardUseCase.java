package com.sample.application.port.in;

import java.net.SocketTimeoutException;
import java.time.zone.ZoneRulesException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sample.domain.Board;

@Service
public interface IBoardUseCase {
  // 조회.
  public List<Board> getList(String boardId);

  // 상세 조회.
  public Board getDetail(String boardId) throws ZoneRulesException, SocketTimeoutException;

  // 등록.
  public int register(Board board);

  // 수정.
  public Board update(Board board);

  // 삭제.
  public int delete(Board board);

  // 생성.
  public int create();
}
