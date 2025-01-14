package com.sample.adapter.in.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.application.port.in.IBoardUseCase;
import com.sample.domain.Board;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final IBoardUseCase boardUseCase;

    @GetMapping("/hi")
    public String getHi(@RequestParam String param) {
        return "hi~";
    }

    @GetMapping("/list")
    public ResponseEntity<List<Board>> getList() {
        return ResponseEntity.ok(boardUseCase.getList("0"));
    }

}
