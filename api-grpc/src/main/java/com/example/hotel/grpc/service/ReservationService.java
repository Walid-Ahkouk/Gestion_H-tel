package com.example.hotel.grpc.service;

import com.example.hotel.grpc.model.Reservation;
import com.example.hotel.grpc.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository repository;

    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
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

    public Optional<Reservation> findById(Long id) {
        return repository.findById(id);
    }
}
