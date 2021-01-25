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
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "direction_from")
    private String directionFrom;

    @Column(name = "direction_to")
    private String directionTo;

    @Column(name = "departure_time")
    private LocalDate departureTime;

    @Column(name = "arrival_time")
    private LocalDate arrivalTime;

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

    @ManyToMany(mappedBy = "rides")
    private Set<UserEntity> users = new LinkedHashSet<>();

}
