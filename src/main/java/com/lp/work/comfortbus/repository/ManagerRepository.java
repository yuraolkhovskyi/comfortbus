package com.lp.work.comfortbus.repository;

import com.lp.work.comfortbus.entity.ManagerEntity;
import com.lp.work.comfortbus.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<ManagerEntity, Long> {
}
