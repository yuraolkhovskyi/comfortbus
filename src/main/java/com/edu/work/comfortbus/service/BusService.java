package com.edu.work.comfortbus.service;

import com.edu.work.comfortbus.domain.BusEntity;

import java.util.List;

public interface BusService {

    BusEntity save(final BusEntity bus);

    List<BusEntity> findAll();

    BusEntity findById(final Long busId);

    BusEntity update(final BusEntity busEntityForUpdate);

    Long delete(final Long busId);

}
