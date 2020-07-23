/*
package com.dwalt.kodillaprojectbackend;

import com.dwalt.kodillaprojectbackend.reservation.Reservation;
import com.dwalt.kodillaprojectbackend.reservation.ReservationRepoService;
import com.dwalt.kodillaprojectbackend.room.Color;
import com.dwalt.kodillaprojectbackend.room.Room;
import com.dwalt.kodillaprojectbackend.room.RoomRepoService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Component
public class Start {
    public Start(RoomRepoService roomRepoService, ReservationRepoService reservationRepoService) {
        Random random = new Random();
        Room room1 = Room.builder()
                .capacity(5)
                .color(Color.RED)
                .title("Pokoj 1")
                .description("Description for room 1")
                .imageUrl("https://picsum.photos/200/300?random=" + random.nextInt(100))
                .pricePerDay(120)
                .reservations(new ArrayList<>())
                .build();

        Reservation reservation1 = Reservation.builder()
                .fromDate(LocalDate.now().plusDays(20))
                .toDate(LocalDate.now().plusDays(27))
                .build();

        //roomRepoService.addRoom(room1);
        Room roomById = roomRepoService.findRoomById(3L).get();
        List<Room> rooms = new ArrayList<>();
        rooms.add(roomById);
        reservation1.setRooms(rooms);

        reservationRepoService.addReservation(reservation1);
        //reservationRepoService.addReservation(reservation1);



    }
}
*/
