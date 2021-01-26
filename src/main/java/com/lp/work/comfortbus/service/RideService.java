package com.lp.work.comfortbus.service;

import com.lp.work.comfortbus.dto.RideDTO;
import com.lp.work.comfortbus.entity.*;
import com.lp.work.comfortbus.repository.RideRepository;
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
    public RideEntity save(final RideDTO rideDTO) {

        DriverEntity driverEntity = driverService.findById(rideDTO.getDriverId());
        ManagerEntity managerEntity = managerService.findById(rideDTO.getManagerId());
        BusEntity busEntity = busService.findById(rideDTO.getBusId());

        Set<UserEntity> users = new LinkedHashSet<>();
        for (Long userId : rideDTO.getUsers()) {
            UserEntity user = userService.findById(userId);
            users.add(user);
        }

        RideEntity rideEntity = new RideEntity();

        if (Objects.nonNull(rideDTO.getId())) {
            RideEntity rideEntityById = findById(rideDTO.getId());
            rideEntity.setId(rideEntityById.getId());
        }

        rideEntity.setDirectionFrom(rideDTO.getDirectionFrom());
        rideEntity.setDirectionTo(rideDTO.getDirectionTo());
        rideEntity.setDepartureDate(rideDTO.getDepartureDate());
        rideEntity.setArrivalDate(rideDTO.getArrivalDate());
        rideEntity.setRideStatus(rideDTO.getRideStatus());
        rideEntity.setDriver(driverEntity);
        rideEntity.setManager(managerEntity);
        rideEntity.setBus(busEntity);
        rideEntity.setUsers(users);


        return rideRepository.save(rideEntity);
    }

    //read
    public List<RideEntity> findAll() {
        return rideRepository.findAll();
    }

    public RideEntity findById(final Long rideId) {
        Optional<RideEntity> ride = rideRepository.findById(rideId);
        if (ride.isEmpty()) {
            throw new RuntimeException("There is no ride with such id:" + rideId);
        }
        return ride.get();
    }

    //update
    public RideEntity update(final RideDTO rideDTOForUpdate) {
        return save(rideDTOForUpdate);
    }

    //delete
    public Long delete(final Long rideId) {
        rideRepository.deleteById(rideId);
        return rideId;
    }

}
