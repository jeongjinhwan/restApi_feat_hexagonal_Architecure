package com.sample.adapter.out.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.kma.adapter.out.vo.ResUltraSrtNcstVO;
import com.kma.adapter.out.web.KmaApiClient;
import com.sample.application.port.out.IBoardOutPort;
import com.sample.domain.Board;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardRepository implements IBoardOutPort {

    private final KmaApiClient kmaClient;

    @Override
    public List<Board> getList(String boardId) {
        int incNum = 0;
        return Arrays.asList(
                Board.builder().boardNo(incNum++).title("title").contents("contents").author("jh").build(),
                Board.builder().boardNo(incNum++).title("제목").contents("내용").author("진환").build(),
                Board.builder().boardNo(incNum++).title("title1").contents("contents2").author("hj").build()
                );
    }

    @Override
    public int register(Board board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'register'");
    }

    @Override
    public Board update(Board board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(Board board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int create() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public ResUltraSrtNcstVO getUltraSrtNcst(String serviceKey, String numOfRows, String pageNo, String dataType, String baseDate, String baseTime, String nx, String ny) {
        ResponseEntity<ResUltraSrtNcstVO> getUltraSrtNcst = kmaClient.getUltraSrtNcst(serviceKey, numOfRows, pageNo, dataType, baseDate, baseTime, nx, ny);
        return getUltraSrtNcst.getBody();
    }

}
