package com.example.hotel.grpc.proto;

public class CreateReservationRequest {
    private String userId;
    private String hotelId;
    private String checkInDate;
    private String checkOutDate;
    private String preferences;

    public String getUserId() {
        return userId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public String getPreferences() {
        return preferences;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private CreateReservationRequest req = new CreateReservationRequest();

        public Builder setUserId(String v) {
            req.userId = v;
            return this;
        }

        public Builder setHotelId(String v) {
            req.hotelId = v;
            return this;
        }

        public Builder setCheckInDate(String v) {
            req.checkInDate = v;
            return this;
        }

        public Builder setCheckOutDate(String v) {
            req.checkOutDate = v;
            return this;
        }

        public Builder setPreferences(String v) {
            req.preferences = v;
            return this;
        }

        public CreateReservationRequest build() {
            return req;
        }
    }
}
