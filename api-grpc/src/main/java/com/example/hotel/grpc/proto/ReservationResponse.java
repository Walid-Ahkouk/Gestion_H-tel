package com.example.hotel.grpc.proto;

public class ReservationResponse {
    private long id;
    private String userId;
    private String hotelId;
    private String checkInDate;
    private String checkOutDate;
    private String status;
    private String preferences;

    public long getId() {
        return id;
    }

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

    public String getStatus() {
        return status;
    }

    public String getPreferences() {
        return preferences;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private ReservationResponse res = new ReservationResponse();

        public Builder setId(long v) {
            res.id = v;
            return this;
        }

        public Builder setUserId(String v) {
            res.userId = v;
            return this;
        }

        public Builder setHotelId(String v) {
            res.hotelId = v;
            return this;
        }

        public Builder setCheckInDate(String v) {
            res.checkInDate = v;
            return this;
        }

        public Builder setCheckOutDate(String v) {
            res.checkOutDate = v;
            return this;
        }

        public Builder setStatus(String v) {
            res.status = v;
            return this;
        }

        public Builder setPreferences(String v) {
            res.preferences = v;
            return this;
        }

        public ReservationResponse build() {
            return res;
        }
    }
}
