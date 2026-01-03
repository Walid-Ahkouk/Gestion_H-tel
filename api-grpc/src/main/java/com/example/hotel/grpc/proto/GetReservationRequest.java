package com.example.hotel.grpc.proto;

public class GetReservationRequest {
    private long id;

    public long getId() {
        return id;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private GetReservationRequest req = new GetReservationRequest();

        public Builder setId(long v) {
            req.id = v;
            return this;
        }

        public GetReservationRequest build() {
            return req;
        }
    }
}
