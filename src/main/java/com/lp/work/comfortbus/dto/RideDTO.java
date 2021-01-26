package com.lp.work.comfortbus.dto;

import com.lp.work.comfortbus.entity.BusEntity;
import com.lp.work.comfortbus.entity.DriverEntity;
import com.lp.work.comfortbus.entity.ManagerEntity;
import com.lp.work.comfortbus.entity.UserEntity;
import com.lp.work.comfortbus.entity.enumeration.RideStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideDTO {

    private Long id;

    private String directionFrom;

    private String directionTo;

    private LocalDate departureDate;

    private LocalDate arrivalDate;

    private RideStatus rideStatus;

    private Long driverId;

    private Long managerId;

    private Long busId;

    private Set<Long> users;


}
