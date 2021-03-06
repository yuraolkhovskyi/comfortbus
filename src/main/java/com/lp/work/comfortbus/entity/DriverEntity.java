package com.lp.work.comfortbus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "drivers")
@AllArgsConstructor
@NoArgsConstructor
public class DriverEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "driver", fetch = FetchType.LAZY)
    private List<RideEntity> rides;


}
