package com.edu.work.comfortbus.service;

import com.edu.work.comfortbus.domain.RideEntity;
import com.edu.work.comfortbus.dto.ride.RequestRideDTO;
import com.edu.work.comfortbus.dto.ride.ResponseRideDTO;

import java.util.List;

public interface RideService {

    ResponseRideDTO save(final RequestRideDTO requestRideDTO);

    RideEntity findById(final Long rideId);

    List<RideEntity> findAll();

    ResponseRideDTO update(final RequestRideDTO requestRideDTOForUpdate);

    Long delete(final Long rideId);

    List<RideEntity> findRidesByParams(String directionFrom, String directionTo, String dateOfTrip, Long amountOfPassengers);
}
