package com.edu.work.comfortbus.repository;

import com.edu.work.comfortbus.domain.BusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<BusEntity, Long> {
}
