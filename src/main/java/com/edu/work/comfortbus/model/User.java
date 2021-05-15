package com.edu.work.comfortbus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String email;
    private String password;
    private Boolean enabled;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String birthDate;
//    private UserRole userRole;
    private String username;
    private String properties;


}
