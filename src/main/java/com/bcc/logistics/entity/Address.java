package com.bcc.logistics.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "address", schema = "logistics")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="address_line_1")
    private String addressLine1;

    @Column(name="address_line_2")
    private String addressLine2;

    @Column(name="district")
    private String district;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "pickupAddress")
    private List<Shipment> shipmentsByPickup;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "deliveryAddress")
    private List<Shipment> shipmentsByDelivery;
}
