package com.bcc.logistics.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "package", schema = "logistics")
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "height")
    private long height;

    @Column(name = "width")
    private long width;

    @Column(name = "length")
    private long length;

    @Column(name = "weight")
    private long weight;

    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinColumn(name="shipment_id")
    private Shipment shipment; //foreign key nerdeyse join column oraya yazilir
}
