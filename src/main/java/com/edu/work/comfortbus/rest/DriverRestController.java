package com.edu.work.comfortbus.rest;

import com.edu.work.comfortbus.dto.driver.ResponseDriverDTO;
import com.edu.work.comfortbus.model.DriverEntity;
import com.edu.work.comfortbus.service.DriverService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/driver")
@AllArgsConstructor
public class DriverRestController {

    private final DriverService driverService;

    @PostMapping(value = "/save")
    @ResponseStatus(value = HttpStatus.CREATED)
    public DriverEntity save(@RequestBody final DriverEntity driverEntity) {
        return driverService.save(driverEntity);
    }

    @GetMapping(value = "/list")
    @ResponseStatus(value = HttpStatus.OK)
    public List<ResponseDriverDTO> findAllDrivers() {
        return driverService.findAll();
    }

    @GetMapping(value = "/get/{driverId}")
    @ResponseStatus(value = HttpStatus.OK)
    public DriverEntity findDriverById(@PathVariable final Long driverId) {
        return driverService.findById(driverId);
    }

    @PatchMapping(value = "/update")
    @ResponseStatus(value = HttpStatus.OK)
    public DriverEntity update(@RequestBody final DriverEntity driverEntity) {
        return driverService.update(driverEntity);
    }

    @DeleteMapping(value = "/delete/{driverId}")
    @ResponseStatus(value = HttpStatus.OK)
    public Long delete(@PathVariable final Long driverId) {
        return driverService.delete(driverId);
    }


}