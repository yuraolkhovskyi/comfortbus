package com.edu.work.comfortbus.repository;

import com.edu.work.comfortbus.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findUserByUsername(String username);

}
