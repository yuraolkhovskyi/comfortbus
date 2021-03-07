package com.edu.work.comfortbus.repository;

import com.edu.work.comfortbus.model.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<DriverEntity, Long> {
}
