package com.texoIT.worstMovieCategory.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private Integer idMovie;
    private Integer yearMovie;
    private String titleMovie;
    private List<String> studios;
    private List<String> producers;
    private Boolean isWinnerMovie;
}
