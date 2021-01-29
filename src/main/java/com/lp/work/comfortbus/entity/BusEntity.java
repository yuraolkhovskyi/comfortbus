package com.lp.work.comfortbus.entity;

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

    @Column(name = "bus_number", updatable = false)
    private String busNumber;

    @Column(name = "number_of_seats", updatable = false)
    private Long numberOfSeats;

    @Column(name = "is_working", updatable = false)
    private Boolean isWorking;

    @Column(name = "is_rosette", updatable = false)
    private Boolean isRosette;

    @Column(name = "is_wifi", updatable = false)
    private Boolean isWiFi;

    @JsonIgnore
    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    private List<RideEntity> rides;

}
