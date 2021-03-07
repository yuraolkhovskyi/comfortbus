package com.edu.work.comfortbus.service;

import com.edu.work.comfortbus.dto.ride.RequestRideDTO;
import com.edu.work.comfortbus.exception.ExceptionConstants;
import com.edu.work.comfortbus.exception.SystemException;
import com.edu.work.comfortbus.model.*;
import com.edu.work.comfortbus.dto.ride.ResponseRideDTO;
import com.edu.work.comfortbus.exception.code.ServiceErrorCode;
import com.edu.work.comfortbus.repository.RideRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class RideService {

    private final RideRepository rideRepository;

    private final BusService busService;
    private final DriverService driverService;
    private final ManagerService managerService;
    private final UserService userService;


    //create
    public ResponseRideDTO save(final RequestRideDTO requestRideDTO) throws IllegalAccessException {

        final DriverEntity driverEntity = driverService.findById(requestRideDTO.getDriverId());
        final ManagerEntity managerEntity = managerService.findById(requestRideDTO.getManagerId());
        final BusEntity busEntity = busService.findById(requestRideDTO.getBusId());

        final Set<UserEntity> users = new LinkedHashSet<>();
        for (Long userId : requestRideDTO.getUsers()) {
            UserEntity user = userService.findById(userId);
            users.add(user);
        }

        final RideEntity rideEntity = new RideEntity();

        //in case if update
        if (Objects.nonNull(requestRideDTO.getId())) {
            RideEntity rideEntityById = findById(requestRideDTO.getId());
            rideEntity.setId(rideEntityById.getId());
        }

        rideEntity.setDirectionFrom(requestRideDTO.getDirectionFrom());
        rideEntity.setDirectionTo(requestRideDTO.getDirectionTo());
        rideEntity.setDepartureDate(requestRideDTO.getDepartureDate());
        rideEntity.setArrivalDate(requestRideDTO.getArrivalDate());
        rideEntity.setRideStatus(requestRideDTO.getRideStatus());
        rideEntity.setDriver(driverEntity);
        rideEntity.setManager(managerEntity);
        rideEntity.setBus(busEntity);
        rideEntity.setUsers(users);


        final RideEntity saved = rideRepository.save(rideEntity);
        return new ResponseRideDTO(
                saved.getId(),
                saved.getDirectionFrom(),
                saved.getDirectionTo(),
                saved.getDepartureDate(),
                saved.getArrivalDate(),
                saved.getRideStatus(),
                saved.getDriver(),
                saved.getManager(),
                saved.getBus(),
                users
        );
    }

    //read
    public List<RideEntity> findAll() {
        return rideRepository.findAll();
    }

    public RideEntity findById(final Long rideId) {
        Optional<RideEntity> ride = rideRepository.findById(rideId);
        if (ride.isEmpty()) {
            throw new SystemException(ExceptionConstants.BAD_REQUEST_MESSAGE, ServiceErrorCode.BAD_REQUEST);
        }
        return ride.get();
    }

    //update
    public ResponseRideDTO update(final RequestRideDTO requestRideDTOForUpdate) throws IllegalAccessException {
        return save(requestRideDTOForUpdate);
    }

    //delete
    public Long delete(final Long rideId) {
        rideRepository.deleteById(rideId);
        return rideId;
    }

}
