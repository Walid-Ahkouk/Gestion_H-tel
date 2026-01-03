package com.example.hotel.graphql.service;

import com.example.hotel.graphql.model.Reservation;
import com.example.hotel.graphql.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository repository;

    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    public List<Reservation> findAll() {
        return repository.findAll();
    }

    public Optional<Reservation> findById(Long id) {
        return repository.findById(id);
    }

    public Reservation createReservation(String userId, String hotelId, String checkInDate, String checkOutDate,
            String preferences) {
        Reservation r = new Reservation();
        r.setUserId(userId);
        r.setHotelId(hotelId);
        if (checkInDate != null)
            r.setCheckInDate(LocalDate.parse(checkInDate));
        if (checkOutDate != null)
            r.setCheckOutDate(LocalDate.parse(checkOutDate));
        r.setPreferences(preferences);
        r.setStatus("CONFIRMED");
        return repository.save(r);
    }
}
