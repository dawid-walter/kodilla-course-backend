package com.dwalt.kodillaprojectbackend.room;

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
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private Color color;
    private String title;
    private String description;
    private int capacity;
    private String imageUrl;
    private double pricePerDay;
    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    private List<Reservation> reservations;
}
