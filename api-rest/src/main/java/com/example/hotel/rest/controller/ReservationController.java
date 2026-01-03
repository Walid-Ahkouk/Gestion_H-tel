package com.example.hotel.rest.controller;

import com.example.hotel.rest.model.Reservation;
import com.example.hotel.rest.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

// Simple DTOs strictly for Controller layer
record CreateReservationRequest(String userId, String hotelId, LocalDate checkInDate, LocalDate checkOutDate,
        String preferences) {
}

record ReservationResponse(Long id, String status) {
}

@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {

    private final ReservationService service;

    public ReservationController(ReservationService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationResponse create(@RequestBody CreateReservationRequest request) {
        Reservation res = new Reservation();
        res.setUserId(request.userId());
        res.setHotelId(request.hotelId());
        res.setCheckInDate(request.checkInDate());
        res.setCheckOutDate(request.checkOutDate());
        res.setPreferences(request.preferences());

        Reservation created = service.createReservation(res);
        return new ReservationResponse(created.getId(), created.getStatus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> get(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
