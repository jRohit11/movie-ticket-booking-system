package com.example.movieTicketBooking.resource;


import com.example.movieTicketBooking.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class MovieResource {

	private long id;

	private String title;

	private Genre genre;

	private List<ReviewResource> reviews;

}