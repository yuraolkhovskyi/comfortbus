package com.lp.work.comfortbus.service;

import com.lp.work.comfortbus.entity.BusEntity;
import com.lp.work.comfortbus.entity.DriverEntity;
import com.lp.work.comfortbus.repository.BusRepository;
import com.lp.work.comfortbus.repository.DriverRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BusService {

    private final BusRepository busRepository;


    //create
    public BusEntity save(final BusEntity bus) {
        return busRepository.save(bus);
    }

    //read
    public List<BusEntity> findAll() {
        return busRepository.findAll();
    }

    public BusEntity findById(final Long busId) {
        Optional<BusEntity> bus = busRepository.findById(busId);
        if (bus.isEmpty()) {
            throw new RuntimeException("There is no bus with such id:" + busId);
        }
        return bus.get();
    }

    //update
    public BusEntity update(final BusEntity busEntityForUpdate) {
        if (Objects.isNull(busEntityForUpdate.getId())) {
            save(busEntityForUpdate);
        }

        final BusEntity bus = findById(busEntityForUpdate.getId());

        bus.setBusNumber(busEntityForUpdate.getBusNumber());
        bus.setNumberOfSeats(busEntityForUpdate.getNumberOfSeats());
        bus.setIsWorking(busEntityForUpdate.getIsWorking());
        bus.setIsRosette(busEntityForUpdate.getIsRosette());
        bus.setIsWiFi(busEntityForUpdate.getIsWiFi());

        return save(bus);
    }

    //delete
    public Long delete(final Long busId) {
        busRepository.deleteById(busId);
        return busId;
    }

}
