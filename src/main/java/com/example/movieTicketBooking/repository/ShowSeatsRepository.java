package com.example.movieTicketBooking.repository;


import com.example.movieTicketBooking.domain.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatsRepository extends JpaRepository<ShowSeat, Long> {

}