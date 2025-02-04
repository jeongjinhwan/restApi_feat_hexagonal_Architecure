package com.sample.application.service;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.kma.adapter.out.vo.ResUltraSrtNcstVO;
import com.sample.application.port.in.IBoardUseCase;
import com.sample.application.port.out.IBoardOutPort;
import com.sample.domain.Board;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService implements IBoardUseCase {

    @Value("${auth.kma.deckey}")
    String serviceKey;
    
    private final static String SEOUL = "asia/seoul";
    private final static String YYYY_MM_DD = "yyyyMMdd";

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
    public Board getDetail(String boardId) throws Exception {

        String baseDate = LocalDate.now(Clock.system(ZoneId.of(SEOUL))).format(DateTimeFormatter.ofPattern(YYYY_MM_DD));

        String numOfRows = "10";
        String pageNo = "1";
        String dataType = "JSON";
        String baseTime = "0500";
        String nx = "55";
        String ny = "127";

        // feign 호출 결과 확인.
        ResUltraSrtNcstVO resUltraSrtNcstVO = boardOutPort.getUltraSrtNcst(serviceKey, numOfRows, pageNo, dataType, baseDate, baseTime, nx, ny);
        if (ObjectUtils.isEmpty(resUltraSrtNcstVO)) {
            throw new Exception("userClient.getDetail body is empty");
        }
        return Board.builder().boardNo(0).contents(resUltraSrtNcstVO.toString()).author("").build();
    }

}
