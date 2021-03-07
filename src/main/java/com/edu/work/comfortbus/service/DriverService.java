package com.edu.work.comfortbus.service;

import com.edu.work.comfortbus.exception.ExceptionConstants;
import com.edu.work.comfortbus.exception.SystemException;
import com.edu.work.comfortbus.exception.code.ServiceErrorCode;
import com.edu.work.comfortbus.model.DriverEntity;
import com.edu.work.comfortbus.dto.driver.ResponseDriverDTO;
import com.edu.work.comfortbus.repository.DriverRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;

    //create
    public DriverEntity save(final DriverEntity driver) {
        return driverRepository.save(driver);
    }

    //read
    public List<ResponseDriverDTO> findAll() {
        List<DriverEntity> drivers = driverRepository.findAll();

        return drivers.stream()
                .map(e -> new ResponseDriverDTO(
                        e.getFirstName(),
                        e.getLastName(),
                        e.getBirthDate(),
                        e.getPhoneNumber()
                ))
                .collect(Collectors.toList());

    }

    public DriverEntity findById(final Long driverId) {
        Optional<DriverEntity> driver = driverRepository.findById(driverId);
        if (driver.isEmpty()) {
            throw new SystemException(ExceptionConstants.BAD_REQUEST_MESSAGE, ServiceErrorCode.BAD_REQUEST);
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
