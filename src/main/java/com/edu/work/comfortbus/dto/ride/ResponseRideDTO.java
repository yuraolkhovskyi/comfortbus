package com.edu.work.comfortbus.dto.ride;

import com.edu.work.comfortbus.model.BusEntity;
import com.edu.work.comfortbus.model.UserEntity;
import com.edu.work.comfortbus.model.enumeration.RideStatus;
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
