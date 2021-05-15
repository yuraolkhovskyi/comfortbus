package com.edu.work.comfortbus.domain;

//import com.edu.work.comfortbus.domain.enumeration.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"rides", "comments"})
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

//    @JsonIgnore
//    @NotNull
//    @Column(name = "password", length = 60)
//    private String password;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "first_name", length = 200)
    private String firstName;

    @Column(name = "last_name", length = 200)
    private String lastName;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "birth_date")
    private String birthDate;

//    @Column(name = "user_role")
//    private UserRole userRole;

    @Column(name = "user_name", length = 40, nullable = false)
    private String username;

    @Column(name = "properties", length = 40, nullable = false)
    private String properties;

    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    private Set<RideEntity> rides;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<CommentEntity> comments;
}
