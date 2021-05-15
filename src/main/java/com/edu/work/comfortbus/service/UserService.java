package com.edu.work.comfortbus.service;

import com.edu.work.comfortbus.domain.UserEntity;
import com.edu.work.comfortbus.dto.user.ResponseUserDTO;

import java.util.List;

public interface UserService {

    UserEntity save(final UserEntity userEntity);

    List<ResponseUserDTO> findAll();

    UserEntity findById(final Long userId);

    UserEntity update(final UserEntity userEntityForUpdate);

    Long delete(final Long driverId);

}
