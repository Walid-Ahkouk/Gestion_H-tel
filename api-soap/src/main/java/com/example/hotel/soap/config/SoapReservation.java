package com.example.hotel.soap.config;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoapReservation", namespace = "http://example.com/soap", propOrder = {
        "id",
        "userId",
        "hotelId",
        "checkInDate",
        "checkOutDate",
        "status",
        "preferences"
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SoapReservation {
    @XmlElement(namespace = "http://example.com/soap", required = true)
    protected long id;

    @XmlElement(namespace = "http://example.com/soap", required = true)
    protected String userId;

    @XmlElement(namespace = "http://example.com/soap", required = true)
    protected String hotelId;

    @XmlElement(namespace = "http://example.com/soap", required = true)
    protected String checkInDate;

    @XmlElement(namespace = "http://example.com/soap", required = true)
    protected String checkOutDate;

    @XmlElement(namespace = "http://example.com/soap", required = true)
    protected String status;

    @XmlElement(namespace = "http://example.com/soap", required = true)
    protected String preferences;
}
