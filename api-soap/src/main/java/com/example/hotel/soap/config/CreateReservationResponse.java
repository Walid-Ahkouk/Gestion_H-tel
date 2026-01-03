package com.example.hotel.soap.config;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CreateReservationResponse", namespace = "http://example.com/soap")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateReservationResponse {
    @XmlElement(name = "reservation", namespace = "http://example.com/soap")
    private SoapReservation reservation;
}
