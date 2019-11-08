package com.texoIT.worstMovieCategory.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Producer {
    private Item min;
    private Item max;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Item {
        private String producer;
        private Integer interval;
        private Integer previousWin;
        private Integer followingWin;
    }
}
