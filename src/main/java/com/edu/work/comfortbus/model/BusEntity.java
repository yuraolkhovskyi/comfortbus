package com.edu.work.comfortbus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "buses")
@AllArgsConstructor
@NoArgsConstructor
public class BusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "bus_number")
    private String busNumber;

    @Column(name = "number_of_seats", updatable = false)
    private Long numberOfSeats;

    @Column(name = "is_working")
    private Boolean isWorking;

    @Column(name = "is_rosette")
    private Boolean isRosette;

    @Column(name = "is_wifi")
    private Boolean isWiFi;

    @JsonIgnore
    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    private List<RideEntity> rides;

}
