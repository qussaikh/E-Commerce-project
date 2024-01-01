package com.qussai.security.webService.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class MovieRequest {

    private Integer id;
    private String title;
    private int rating;
    private String description;
}
