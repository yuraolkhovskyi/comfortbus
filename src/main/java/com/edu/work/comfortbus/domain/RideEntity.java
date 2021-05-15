package com.edu.work.comfortbus.domain;

import com.edu.work.comfortbus.domain.enumeration.RideStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "rides")
@AllArgsConstructor
@NoArgsConstructor
public class RideEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "direction_from")
    private String directionFrom;

    @Column(name = "direction_to")
    private String directionTo;

    @Column(name = "date_of_trip")
    private LocalDateTime dateOfTrip;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "departure_date")
    private LocalDate departureDate;

    @Column(name = "arrival_date")
    private LocalDate arrivalDate;

    @Enumerated(EnumType.STRING)
    private RideStatus rideStatus;

    @Column(name = "passengers_amount")
    private Integer amountOfPassengers;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private UserEntity driver;

    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = false)
    private UserEntity manager;

    @ManyToOne
    @JoinColumn(name = "bus_id", nullable = false)
    private BusEntity bus;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ride_user",
            joinColumns = {
                    @JoinColumn(name = "ride_id"),
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id")
            }
    )
    private Set<UserEntity> users = new LinkedHashSet<>();

}
