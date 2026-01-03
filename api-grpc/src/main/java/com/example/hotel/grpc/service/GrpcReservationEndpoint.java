package com.example.hotel.grpc.service;

import com.example.hotel.grpc.model.Reservation;
import com.example.hotel.grpc.proto.*;
import net.devh.boot.grpc.server.service.GrpcService;
import io.grpc.stub.StreamObserver;

@GrpcService
public class GrpcReservationEndpoint extends ReservationServiceGrpc.ReservationServiceImplBase {

    private final ReservationService service;

    public GrpcReservationEndpoint(ReservationService service) {
        this.service = service;
    }

    @Override
    public void createReservation(CreateReservationRequest req, StreamObserver<ReservationResponse> responseObserver) {
        Reservation r = service.createReservation(
                req.getUserId(),
                req.getHotelId(),
                req.getCheckInDate(),
                req.getCheckOutDate(),
                req.getPreferences());

        ReservationResponse resp = mapToResponse(r);
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }

    @Override
    public void getReservation(GetReservationRequest req, StreamObserver<ReservationResponse> responseObserver) {
        service.findById(req.getId()).ifPresentOrElse(r -> {
            responseObserver.onNext(mapToResponse(r));
            responseObserver.onCompleted();
        }, () -> {
            responseObserver.onError(io.grpc.Status.NOT_FOUND
                    .withDescription("Reservation not found with ID: " + req.getId())
                    .asRuntimeException());
        });
    }

    private ReservationResponse mapToResponse(Reservation r) {
        ReservationResponse.Builder builder = ReservationResponse.newBuilder()
                .setId(r.getId())
                .setUserId(r.getUserId())
                .setHotelId(r.getHotelId())
                .setStatus(r.getStatus());

        if (r.getCheckInDate() != null)
            builder.setCheckInDate(r.getCheckInDate().toString());
        if (r.getCheckOutDate() != null)
            builder.setCheckOutDate(r.getCheckOutDate().toString());
        if (r.getPreferences() != null)
            builder.setPreferences(r.getPreferences());

        return builder.build();
    }
}
