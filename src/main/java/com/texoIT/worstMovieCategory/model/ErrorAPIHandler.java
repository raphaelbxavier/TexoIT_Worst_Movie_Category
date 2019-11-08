package com.texoIT.worstMovieCategory.model;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ErrorAPIHandler {
    private HttpStatus httpStatus;
    private String messageError;
    private String messagePath;
}
