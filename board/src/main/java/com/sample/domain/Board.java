package com.sample.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Board {
  private int boardNo; // 글번호.
  private String title; // 제목.
  private String contents; // 내용.
  private String author; // 글쓴이.
}
