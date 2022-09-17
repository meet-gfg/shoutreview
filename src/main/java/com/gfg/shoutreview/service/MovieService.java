package com.gfg.shoutreview.service;

import com.gfg.shoutreview.domain.Genre;
import com.gfg.shoutreview.domain.Movie;
import com.gfg.shoutreview.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie findMovie(String title){
        return movieRepository.findByTitle(title);
    }

    public List<Movie> findMoviesByGenre(String genre){
        if(Arrays.stream(Genre.values()).noneMatch(g ->g.toString().equals(genre)))
                return new ArrayList<>();
        return movieRepository.findByGenre(Genre.valueOf(genre));
    }


}
