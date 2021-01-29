package com.lp.work.comfortbus.dto.driver;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDriverDTO {

    private String firstName;
    private String lastName;
    private String birthDate;
    private String phoneNumber;

}
