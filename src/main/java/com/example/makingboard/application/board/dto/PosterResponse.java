package com.example.makingboard.application.board.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PosterResponse {

    private List<PosterVO> posters = new ArrayList<>();

}
