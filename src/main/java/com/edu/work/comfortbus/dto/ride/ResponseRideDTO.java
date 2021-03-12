package com.edu.work.comfortbus.dto.ride;

import com.edu.work.comfortbus.domain.BusEntity;
import com.edu.work.comfortbus.domain.UserEntity;
import com.edu.work.comfortbus.domain.enumeration.RideStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseRideDTO {

    private Long id;

    private String directionFrom;

    private String directionTo;

    private LocalDate departureDate;

    private LocalDate arrivalDate;

    private RideStatus rideStatus;

    private UserEntity driverEntity;

    private UserEntity managerEntity;

    private BusEntity busEntity;

    private Set<UserEntity> users;

}
