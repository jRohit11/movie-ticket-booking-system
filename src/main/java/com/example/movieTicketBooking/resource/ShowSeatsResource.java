package com.example.movieTicketBooking.resource;


import com.example.movieTicketBooking.enums.SeatType;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class ShowSeatsResource {

	private long id;

	private String seatNumber;

	private int rate;

	private SeatType seatType;

	private boolean booked;

	private Date bookedAt;

}