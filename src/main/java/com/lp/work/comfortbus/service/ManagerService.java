package com.lp.work.comfortbus.service;

import com.lp.work.comfortbus.entity.ManagerEntity;
import com.lp.work.comfortbus.repository.ManagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ManagerService {

    private final ManagerRepository managerRepository;

    //create
    public ManagerEntity save(final ManagerEntity manager) {
        return managerRepository.save(manager);
    }

    //read
    public List<ManagerEntity> findAll() {
        return managerRepository.findAll();
    }

    public ManagerEntity findById(final Long driverId) {
        Optional<ManagerEntity> manager = managerRepository.findById(driverId);
        if (manager.isEmpty()) {
            throw new RuntimeException("There is no manager with such id:" + driverId);
        }
        return manager.get();
    }

    //update
    public ManagerEntity update(final ManagerEntity managerEntityForUpdate) {
        if (Objects.isNull(managerEntityForUpdate.getId())) {
            save(managerEntityForUpdate);
        }

        final ManagerEntity driver = findById(managerEntityForUpdate.getId());

        driver.setFirstName(managerEntityForUpdate.getFirstName());
        driver.setLastName(managerEntityForUpdate.getLastName());
        driver.setBirthDate(managerEntityForUpdate.getBirthDate());
        driver.setPhoneNumber(managerEntityForUpdate.getPhoneNumber());

        return save(driver);
    }

    //delete
    public Long delete(final Long driverId) {
        managerRepository.deleteById(driverId);
        return driverId;
    }

}
