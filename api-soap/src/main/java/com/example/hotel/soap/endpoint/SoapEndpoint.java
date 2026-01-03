package com.example.hotel.soap.endpoint;

import com.example.hotel.soap.model.Reservation;
import com.example.hotel.soap.service.ReservationService;
import com.example.hotel.soap.config.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import java.time.LocalDate;

@Endpoint
public class SoapEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/soap";
    private final ReservationService service;

    public SoapEndpoint(ReservationService service) {
        this.service = service;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetReservationRequest")
    @ResponsePayload
    public GetReservationResponse get(@RequestPayload GetReservationRequest req) {
        System.out.println("SOAP: Reçu demande GetReservation pour ID=" + req.getId());
        GetReservationResponse res = new GetReservationResponse();

        service.findById(req.getId()).ifPresentOrElse(entity -> {
            System.out.println("SOAP: Trouvé entité " + entity);
            SoapReservation dto = mapToDto(entity);
            res.setReservation(dto);
        }, () -> System.out.println("SOAP: Aucune réservation trouvée pour ID=" + req.getId()));

        return res;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreateReservationRequest")
    @ResponsePayload
    public CreateReservationResponse create(@RequestPayload CreateReservationRequest req) {
        System.out.println("SOAP: Create Req " + req.getUserId());

        Reservation r = new Reservation();
        r.setUserId(req.getUserId());
        r.setHotelId(req.getHotelId());
        if (req.getCheckInDate() != null)
            r.setCheckInDate(LocalDate.parse(req.getCheckInDate()));
        if (req.getCheckOutDate() != null)
            r.setCheckOutDate(LocalDate.parse(req.getCheckOutDate()));
        r.setPreferences(req.getPreferences());
        r.setStatus("CONFIRMED");

        Reservation entity = service.save(r); // Updated to use save direct or service method

        CreateReservationResponse res = new CreateReservationResponse();
        res.setReservation(mapToDto(entity));
        return res;
    }

    private SoapReservation mapToDto(Reservation entity) {
        SoapReservation dto = new SoapReservation();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUserId());
        dto.setHotelId(entity.getHotelId());
        if (entity.getCheckInDate() != null)
            dto.setCheckInDate(entity.getCheckInDate().toString());
        if (entity.getCheckOutDate() != null)
            dto.setCheckOutDate(entity.getCheckOutDate().toString());
        dto.setStatus(entity.getStatus());
        dto.setPreferences(entity.getPreferences());
        return dto;
    }
}
