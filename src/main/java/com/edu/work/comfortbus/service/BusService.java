package com.edu.work.comfortbus.service;

import com.edu.work.comfortbus.exception.ExceptionConstants;
import com.edu.work.comfortbus.exception.SystemException;
import com.edu.work.comfortbus.exception.code.ServiceErrorCode;
import com.edu.work.comfortbus.model.BusEntity;
import com.edu.work.comfortbus.repository.BusRepository;
import lombok.AllArgsConstructor;
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
            throw new SystemException(ExceptionConstants.BAD_REQUEST_MESSAGE, ServiceErrorCode.BAD_REQUEST);
        }
        return bus.get();
    }

    //update
    public BusEntity update(final BusEntity busEntityForUpdate) {
        if (Objects.isNull(busEntityForUpdate.getId())) {
            return save(busEntityForUpdate);
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
