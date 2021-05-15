package com.edu.work.comfortbus.dto.ride;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRideDto {

    private String directionFrom;

    private String directionTo;

    private LocalDateTime dateOfTrip;

    private Integer amountOfPassengers;

}
