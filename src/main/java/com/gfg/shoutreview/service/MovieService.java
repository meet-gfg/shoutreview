package com.gfg.shoutreview.service;

import com.gfg.shoutreview.domain.Genre;
import com.gfg.shoutreview.domain.Movie;
import com.gfg.shoutreview.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Movie> movieList= movieRepository.findByGenre(Genre.valueOf(genre));
        movieList=movieList.stream().sorted(Comparator.comparing(Movie::getRating,Comparator.reverseOrder())).collect(Collectors.toList());
        if(movieList.size()>5)
                return movieList.subList(0,4);
        return movieList;
    }


}
