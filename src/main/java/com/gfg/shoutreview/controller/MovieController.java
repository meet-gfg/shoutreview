package com.gfg.shoutreview.controller;

import com.gfg.shoutreview.domain.Movie;
import com.gfg.shoutreview.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/title")
    public Movie findMovie(String title){
        return movieService.findMovie(title);
    }

    @GetMapping("/genre")
    public List<Movie> findMovieByGenre(@RequestParam String genre){
        return movieService.findMoviesByGenre(genre);
    }

}
