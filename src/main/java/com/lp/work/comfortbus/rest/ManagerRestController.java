package com.lp.work.comfortbus.rest;

import com.lp.work.comfortbus.entity.ManagerEntity;
import com.lp.work.comfortbus.service.ManagerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/manager")
@AllArgsConstructor
public class ManagerRestController {

    private final ManagerService managerService;

    @PostMapping(value = "/save")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ManagerEntity save(@RequestBody final ManagerEntity managerEntity) {
        return managerService.save(managerEntity);
    }

    @GetMapping(value = "/list")
    @ResponseStatus(value = HttpStatus.OK)
    public List<ManagerEntity> findAll() {
        return managerService.findAll();
    }

    @GetMapping(value = "/get/{managerId}")
    @ResponseStatus(value = HttpStatus.OK)
    public ManagerEntity findManagerById(@PathVariable final Long managerId) {
        return managerService.findById(managerId);
    }

    @PatchMapping(value = "/update")
    @ResponseStatus(value = HttpStatus.OK)
    public ManagerEntity update(@RequestBody final ManagerEntity managerId) {
        return managerService.update(managerId);
    }

    @DeleteMapping(value = "/delete/{managerId}")
    @ResponseStatus(value = HttpStatus.OK)
    public Long delete(@PathVariable final Long managerId) {
        return managerService.delete(managerId);
    }


}
