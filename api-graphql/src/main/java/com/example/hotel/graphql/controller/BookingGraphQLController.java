package com.example.hotel.graphql.controller;

import com.example.hotel.graphql.model.Reservation;
import com.example.hotel.graphql.service.ReservationService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class BookingGraphQLController {

    private final ReservationService service;

    public BookingGraphQLController(ReservationService service) {
        this.service = service;
    }

    @QueryMapping
    public List<Reservation> allReservations() {
        return service.findAll();
    }

    @QueryMapping
    public Reservation reservationById(@Argument String id) {
        return service.findById(Long.parseLong(id)).orElse(null);
    }

    @MutationMapping
    public Reservation createReservation(
            @Argument String userId,
            @Argument String hotelId,
            @Argument String checkInDate,
            @Argument String checkOutDate,
            @Argument String preferences) {
        return service.createReservation(userId, hotelId, checkInDate, checkOutDate, preferences);
    }
}
