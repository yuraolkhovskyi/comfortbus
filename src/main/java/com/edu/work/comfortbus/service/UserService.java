package com.edu.work.comfortbus.service;

import com.edu.work.comfortbus.exception.ExceptionConstants;
import com.edu.work.comfortbus.exception.SystemException;
import com.edu.work.comfortbus.model.UserEntity;
import com.edu.work.comfortbus.dto.user.ResponseUserDTO;
import com.edu.work.comfortbus.exception.code.ServiceErrorCode;
import com.edu.work.comfortbus.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //create
    public UserEntity save(final UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    //read
    public List<ResponseUserDTO> findAll() {
        final List<UserEntity> users = userRepository.findAll();

        return users.stream()
                .map(e -> new ResponseUserDTO(e.getFirstName(), e.getLastName(), e.getBirthDate(), e.getPhoneNumber()))
                .collect(Collectors.toList());

    }

    public UserEntity findById(final Long userId) {
        Optional<UserEntity> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new SystemException(ExceptionConstants.BAD_REQUEST_MESSAGE, ServiceErrorCode.BAD_REQUEST);
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
