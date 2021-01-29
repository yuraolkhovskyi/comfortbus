package com.lp.work.comfortbus.rest;

import com.lp.work.comfortbus.dto.ride.RequestRideDTO;
import com.lp.work.comfortbus.dto.ride.ResponseRideDTO;
import com.lp.work.comfortbus.entity.RideEntity;
import com.lp.work.comfortbus.service.RideService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ride")
@AllArgsConstructor
public class RideRestController {

    private final RideService rideService;

    @PostMapping(value = "/save")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseRideDTO save(@RequestBody final RequestRideDTO requestRideDTO) throws IllegalAccessException {
        return rideService.save(requestRideDTO);
    }

    @GetMapping(value = "/list")
    @ResponseStatus(value = HttpStatus.OK)
    public List<RideEntity> findAllRides() {
        return rideService.findAll();
    }

    @GetMapping(value = "/get/{rideId}")
    @ResponseStatus(value = HttpStatus.OK)
    public RideEntity findRideById(@PathVariable final Long rideId) {
        return rideService.findById(rideId);
    }

    @PatchMapping(value = "/update")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseRideDTO update(@RequestBody final RequestRideDTO requestRideDTO) throws IllegalAccessException {
        return rideService.update(requestRideDTO);
    }

    @DeleteMapping(value = "/delete/{rideId}")
    @ResponseStatus(value = HttpStatus.OK)
    public Long delete(@PathVariable final Long rideId) {
        return rideService.delete(rideId);
    }


}
