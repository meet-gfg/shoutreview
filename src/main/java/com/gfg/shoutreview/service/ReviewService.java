package com.gfg.shoutreview.service;

import com.gfg.shoutreview.domain.Movie;
import com.gfg.shoutreview.domain.Review;
import com.gfg.shoutreview.repository.MovieRepository;
import com.gfg.shoutreview.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    public void addReview(Review review) {
        Movie movie=movieRepository.findById(review.getMovie().getId()).orElse(null);
        if(movie!=null) {
            Double average = reviewRepository.getReviewAverage(movie.getId());
            movie.setRating(average);
            movieRepository.save(movie);
        }
        reviewRepository.save(review);
    }

    public Review getReviewById(Long reviewId) {

        return reviewRepository.findById(reviewId).orElse(null);

    }
}
