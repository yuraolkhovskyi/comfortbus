package com.lp.work.comfortbus.service;

import com.lp.work.comfortbus.entity.UserEntity;
import com.lp.work.comfortbus.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //create
    public UserEntity save(final UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    //read
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public UserEntity findById(final Long userId) {
        Optional<UserEntity> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new RuntimeException("There is no driver with such id:" + userId);
        }
        return user.get();
    }

    //update
    public UserEntity update(final UserEntity userEntityForUpdate) {
        if (Objects.isNull(userEntityForUpdate.getId())) {
            save(userEntityForUpdate);
        }

        final UserEntity driver = findById(userEntityForUpdate.getId());

        driver.setFirstName(userEntityForUpdate.getFirstName());
        driver.setLastName(userEntityForUpdate.getLastName());
        driver.setBirthDate(userEntityForUpdate.getBirthDate());
        driver.setPhoneNumber(userEntityForUpdate.getPhoneNumber());

        return save(driver);
    }

    //delete
    public Long delete(final Long driverId) {
        userRepository.deleteById(driverId);
        return driverId;
    }

}
