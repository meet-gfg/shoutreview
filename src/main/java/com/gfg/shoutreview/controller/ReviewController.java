package com.gfg.shoutreview.controller;

import com.gfg.shoutreview.domain.Review;
import com.gfg.shoutreview.service.ReviewService;
import com.gfg.shoutreview.service.request.ReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/review/add")
    public void addReview(@RequestBody ReviewRequest reviewRequest){
        reviewService.addReview(reviewRequest.toReview());
    }

    @GetMapping("/review/find")
    public Review getReview(@RequestParam Long reviewId){
        return reviewService.getReviewById(reviewId);
    }
}
