package com.edu.work.comfortbus.repository;

import com.edu.work.comfortbus.domain.RideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<RideEntity, Long> {
}
