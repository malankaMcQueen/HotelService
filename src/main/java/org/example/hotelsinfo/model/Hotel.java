package org.example.hotelsinfo.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Data
@Entity
@Table(schema = "hotel", name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "brand")
    private String brand;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address", referencedColumnName = "id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "contacts", referencedColumnName = "id")
    private Contacts contacts;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "arrival_time_id", referencedColumnName = "id")
    private ArrivalTime arrivalTime;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "hotel_amenities", joinColumns = @JoinColumn(name = "hotel_id"))
    private List<String> amenities;
}