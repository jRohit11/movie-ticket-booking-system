package com.example.movieTicketBooking.repository;


import com.example.movieTicketBooking.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{

}