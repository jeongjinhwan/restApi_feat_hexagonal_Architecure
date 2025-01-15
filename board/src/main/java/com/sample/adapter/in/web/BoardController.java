package com.sample.adapter.in.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.adapter.in.dto.BoardDTO;
import com.sample.application.port.in.IBoardUseCase;
import com.sample.domain.Board;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardController implements BoardControllerApi {

    private final IBoardUseCase boardUseCase;

    @GetMapping("/hi")
    public String getHi(@RequestParam String param) {
        return "hi~";
    }

    @GetMapping("/list")
    public ResponseEntity<List<Board>> getList() {
        return ResponseEntity.ok(boardUseCase.getList("0"));
    }

    @Override
    public ResponseEntity<Object> createBoard(
            @Parameter(name = "BoardDTO", description = "", required = true) @Valid @RequestBody BoardDTO boardDTO)
            throws Exception {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
