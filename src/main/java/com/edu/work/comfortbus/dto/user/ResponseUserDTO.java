package com.edu.work.comfortbus.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUserDTO {

    private String firstName;

    private String lastName;

    private String birthDate;

    private String phoneNumber;

}
