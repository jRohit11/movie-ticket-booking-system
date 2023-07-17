package com.example.movieTicketBooking.service;

import com.example.movieTicketBooking.domain.Movie;
import com.example.movieTicketBooking.domain.Review;
import com.example.movieTicketBooking.repository.MovieRepository;
import com.example.movieTicketBooking.repository.ReviewRepository;
import com.example.movieTicketBooking.resource.ReviewResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    public void addReview(Review review) {
        Movie movie=movieRepository.findById(review.getMovie().getId()).orElse(null);
        reviewRepository.save(review);
        //need to optimized
        //exception handling.
        if(movie!=null) {
            Double average = reviewRepository.getReviewAverage(movie.getId());
            movie.setRating(average);
            movieRepository.save(movie);
        }

    }

    public ReviewResource getReviewById(Long reviewId) {

        Optional<Review> review= reviewRepository.findById(reviewId);
        return review.map(Review::toResource).orElse(null);

    }
}
