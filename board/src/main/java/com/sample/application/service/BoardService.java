package com.sample.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sample.application.port.in.IBoardUseCase;
import com.sample.application.port.out.IBoardOutPort;
import com.sample.domain.Board;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService implements IBoardUseCase {

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

}
