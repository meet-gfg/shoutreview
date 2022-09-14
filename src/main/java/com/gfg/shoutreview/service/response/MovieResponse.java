package com.gfg.shoutreview.service.response;


import com.gfg.shoutreview.domain.Genre;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieResponse {

    private String title;
    private Genre genre;
    private Double rating;

}
