package com.example.hotel.soap.service;

import com.example.hotel.soap.model.Reservation;
import com.example.hotel.soap.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository repository;

    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    public Optional<Reservation> findById(Long id) {
        return repository.findById(id);
    }

    public Reservation save(Reservation r) {
        return repository.save(r);
    }

    // Legacy simple signature kept for temp compatibility if needed, but endpoint
    // now constructs object
    public Reservation createReservation(String userId, String hotelId) {
        Reservation r = new Reservation();
        r.setUserId(userId);
        r.setHotelId(hotelId);
        r.setStatus("CONFIRMED");
        return repository.save(r);
    }
}
