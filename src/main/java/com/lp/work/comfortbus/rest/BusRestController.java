package com.lp.work.comfortbus.rest;

import com.lp.work.comfortbus.entity.BusEntity;
import com.lp.work.comfortbus.service.BusService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bus")
@AllArgsConstructor
public class BusRestController {

    private final BusService busService;

    @PostMapping(value = "/save")
    @ResponseStatus(value = HttpStatus.CREATED)
    public BusEntity save(@RequestBody final BusEntity busEntity) {
        return busService.save(busEntity);
    }

    @GetMapping(value = "/list")
    @ResponseStatus(value = HttpStatus.OK)
    public List<BusEntity> findAll() {
        return busService.findAll();
    }

    @GetMapping(value = "/get/{busId}")
    @ResponseStatus(value = HttpStatus.OK)
    public BusEntity findBusById(@PathVariable final Long busId) {
        return busService.findById(busId);
    }

    @PatchMapping(value = "/update")
    @ResponseStatus(value = HttpStatus.OK)
    public BusEntity update(@RequestBody final BusEntity bus) {
        return busService.update(bus);
    }

    @DeleteMapping(value = "/delete/{busId}")
    @ResponseStatus(value = HttpStatus.OK)
    public Long delete(@PathVariable final Long busId) {
        return busService.delete(busId);
    }


}
