package com.lp.work.comfortbus.service;

import com.lp.work.comfortbus.entity.DriverEntity;
import com.lp.work.comfortbus.repository.DriverRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;

    //create
    public DriverEntity save(final DriverEntity driver) {
        return driverRepository.save(driver);
    }

    //read
    public List<DriverEntity> findAll() {
        return driverRepository.findAll();
    }

    public DriverEntity findById(final Long driverId) {
        Optional<DriverEntity> driver = driverRepository.findById(driverId);
        if (driver.isEmpty()) {
            throw new RuntimeException("There is no driver with such id:" + driverId);
        }
        return driver.get();
    }

    //update
    public DriverEntity update(final DriverEntity driverEntityForUpdate) {
        if (Objects.isNull(driverEntityForUpdate.getId())) {
            save(driverEntityForUpdate);
        }

        final DriverEntity driver = findById(driverEntityForUpdate.getId());

        driver.setFirstName(driverEntityForUpdate.getFirstName());
        driver.setLastName(driverEntityForUpdate.getLastName());
        driver.setBirthDate(driverEntityForUpdate.getBirthDate());
        driver.setPhoneNumber(driverEntityForUpdate.getPhoneNumber());

        return save(driver);
    }

    //delete
    public Long delete(final Long driverId) {
        driverRepository.deleteById(driverId);
        return driverId;
    }

}
