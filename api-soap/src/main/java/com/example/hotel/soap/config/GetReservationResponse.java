package com.example.hotel.soap.config;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GetReservationResponse", namespace = "http://example.com/soap")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetReservationResponse {
    @XmlElement(name = "reservation", namespace = "http://example.com/soap")
    private SoapReservation reservation;
}
