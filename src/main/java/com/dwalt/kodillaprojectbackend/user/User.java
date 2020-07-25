package com.dwalt.kodillaprojectbackend.user;

import com.dwalt.kodillaprojectbackend.reservation.Reservation;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String address;
    private String email;
    private Role role;
    private String password;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Reservation> reservations;
}
