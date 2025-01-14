package com.sample.application.port.out;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sample.domain.Board;

/**
 * board out port interface.<br/>
 * 구현체가 없는 경우 build 과정에서 오류가 발생 합니다.
 */
@Service
public interface IBoardOutPort {
    // 조회.
    public List<Board> getList(String boardId);

    // 등록.
    public int register(Board board);

    // 수정.
    public Board update(Board board);

    // 삭제.
    public int delete(Board board);

    // 생성.
    public int create();
}
