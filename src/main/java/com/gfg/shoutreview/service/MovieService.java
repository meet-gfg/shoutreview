package com.gfg.shoutreview.service;

import com.gfg.shoutreview.domain.Genre;
import com.gfg.shoutreview.domain.Movie;
import com.gfg.shoutreview.repository.MovieRepository;
import com.gfg.shoutreview.service.response.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public MovieResponse findMovie(String title) {
        //write fetch from repo.
        // handle not exist scenarios
        //caching logic
        //exception handling
        Movie movie = movieRepository.findByTitle(title);
        if (Objects.nonNull(movie))
            return movie.toMovieResponse();
        return null;
    }

    public List<MovieResponse> findMoviesByGenre(String genre) {
        if (Arrays.stream(Genre.values()).noneMatch(g -> g.toString().equals(genre)))
            return new ArrayList<>();
        List<Movie> movieList = movieRepository.findByGenre(Genre.valueOf(genre));
        if (!CollectionUtils.isEmpty(movieList)) {
            List<MovieResponse> movieResponseList = movieList.stream().sorted(Comparator.comparing(Movie::getRating, Comparator.reverseOrder())).map(m -> m.toMovieResponse()).collect(Collectors.toList());
            if (movieResponseList.size() > 5)
                return movieResponseList.subList(0, 4);
            return movieResponseList;
        }
        return new ArrayList<>();
    }


}
