package com.example.movieTicketBooking.controller;

import com.example.movieTicketBooking.domain.Review;
import com.example.movieTicketBooking.resource.ReviewResource;
import com.example.movieTicketBooking.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/add")
    public void addReview(@RequestBody ReviewResource reviewRequest){
        reviewService.addReview(Review.toEntity(reviewRequest));
    }

    @GetMapping("/find")
    public ReviewResource getReview(@RequestParam Long reviewId){
        return reviewService.getReviewById(reviewId);
    }
}
