package com.example.hotel.soap.config;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GetReservationRequest", namespace = "http://example.com/soap")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetReservationRequest {
    // Force namespace matching for the ID field
    @XmlElement(namespace = "http://example.com/soap")
    private long id;
}
