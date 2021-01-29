package com.lp.work.comfortbus.entity;

import com.lp.work.comfortbus.entity.enumeration.RideStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
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

    @Column(name = "departure_date")
    private LocalDate departureDate;

    @Column(name = "arrival_date")
    private LocalDate arrivalDate;

    @Enumerated(EnumType.STRING)
    private RideStatus rideStatus;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private DriverEntity driver;

    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = false)
    private ManagerEntity manager;

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
