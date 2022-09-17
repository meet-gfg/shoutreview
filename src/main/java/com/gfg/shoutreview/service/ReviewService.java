package com.gfg.shoutreview.service;

import com.gfg.shoutreview.domain.Review;
import com.gfg.shoutreview.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public void addReview(Review review) {
        reviewRepository.save(review);
    }

    public Review getReviewById(Long reviewId) {

        return reviewRepository.findById(reviewId).orElse(null);

    }
}
