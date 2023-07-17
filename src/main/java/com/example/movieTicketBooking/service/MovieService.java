package com.example.movieTicketBooking.service;


import com.example.movieTicketBooking.domain.Movie;
import com.example.movieTicketBooking.exception.NotFoundException;
import com.example.movieTicketBooking.repository.MovieRepository;
import com.example.movieTicketBooking.resource.MovieResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class MovieService {



	@Autowired
	private MovieRepository movieRepository;


	public MovieResource addMovie(MovieResource movieRequest) {

		Movie movie = Movie.toEntity(movieRequest);

		if (movieRepository.existsByTitle(movieRequest.getTitle())) {
				return Movie.toResource(movie);
		}

		movie = movieRepository.save(movie);

		log.info("Added New Movie"+ movie.toString());

		return Movie.toResource(movie);
	}


	public MovieResource getMovie(long id) {
		//add id check if valid
		Optional<Movie> movie = movieRepository.findById(id);

		if (!movie.isPresent()) {
			throw new EntityNotFoundException("Movie not found:" + id);
		}

		return Movie.toResource(movie.get());
	}

	public MovieResource getMovie(String title) {
		//add id check if valid
		Movie movie = movieRepository.findByTitle(title);

		if (Objects.isNull(movie)) {
			throw new NotFoundException("Movie not found:" + title);
		}

		return Movie.toResource(movie);
	}

}