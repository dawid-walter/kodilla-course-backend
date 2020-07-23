package com.dwalt.kodillaprojectbackend.fixtures;

import com.dwalt.kodillaprojectbackend.reservation.Reservation;
import com.dwalt.kodillaprojectbackend.room.Room;
import com.dwalt.kodillaprojectbackend.user.User;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.dwalt.kodillaprojectbackend.room.Color.BLUE;

@Getter
public class EntityFixtures {
    private final Room roomFixture;
    private final Reservation reservationFixture;
    private final List<Reservation> reservationsFixture;
    private final List<Room> roomsFixture;
    private final User userFixture;

    public EntityFixtures() {
        Random random = new Random();
        roomFixture = Room.builder()
                .capacity(3)
                .color(BLUE)
                .title("Room 1")
                .description("Opis pokoju 1")
                .imageUrl("https://picsum.photos/500/300?random=" + random.nextInt(50))
                .pricePerDay(120)
                .build();
        reservationFixture = Reservation.builder()
                .fromDate(LocalDate.now().plusDays(20))
                .toDate(LocalDate.now().plusDays(27))
                .build();
        reservationsFixture = new ArrayList<>();
        roomsFixture = new ArrayList<>();
        userFixture = User.builder()
                .name("Stefan")
                .surname("Kowalski")
                .build();
    }
}
