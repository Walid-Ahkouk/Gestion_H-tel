package com.example.hotel.rest.service;

import com.example.hotel.rest.model.Reservation;
import com.example.hotel.rest.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository repository;

    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    public Reservation createReservation(Reservation reservation) {
        reservation.setStatus("CONFIRMED");
        return repository.save(reservation);
    }

    public Optional<Reservation> findById(Long id) {
        return repository.findById(id);
    }

    public List<Reservation> findAll() {
        return repository.findAll();
    }
}
