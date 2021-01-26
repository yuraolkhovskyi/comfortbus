package com.lp.work.comfortbus.rest;

import com.lp.work.comfortbus.dto.RideDTO;
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
    public RideEntity save(@RequestBody final RideDTO rideDTO) {
        return rideService.save(rideDTO);
    }

    @GetMapping(value = "/list")
    @ResponseStatus(value = HttpStatus.OK)
    public List<RideEntity> findAllDrivers() {
        return rideService.findAll();
    }

    @GetMapping(value = "/get/{rideId}")
    @ResponseStatus(value = HttpStatus.OK)
    public RideEntity findDriverById(@PathVariable final Long rideId) {
        return rideService.findById(rideId);
    }

    @PatchMapping(value = "/update")
    @ResponseStatus(value = HttpStatus.OK)
    public RideEntity update(@RequestBody final RideDTO rideDTO) {
        return rideService.update(rideDTO);
    }

    @DeleteMapping(value = "/delete/{rideId}")
    @ResponseStatus(value = HttpStatus.OK)
    public Long delete(@PathVariable final Long rideId) {
        return rideService.delete(rideId);
    }


}
