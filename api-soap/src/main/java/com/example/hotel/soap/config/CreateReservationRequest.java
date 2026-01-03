package com.example.hotel.soap.config;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CreateReservationRequest", namespace = "http://example.com/soap")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateReservationRequest {
    private String userId;
    private String hotelId;
    private String checkInDate;
    private String checkOutDate;
    private String preferences;
}
