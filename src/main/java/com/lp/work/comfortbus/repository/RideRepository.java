package com.lp.work.comfortbus.repository;

import com.lp.work.comfortbus.entity.BusEntity;
import com.lp.work.comfortbus.entity.RideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<RideEntity, Long> {
}
