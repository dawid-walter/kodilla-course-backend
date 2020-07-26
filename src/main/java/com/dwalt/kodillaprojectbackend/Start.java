package com.dwalt.kodillaprojectbackend;

import com.dwalt.kodillaprojectbackend.reservation.Reservation;
import com.dwalt.kodillaprojectbackend.reservation.ReservationRepoService;
import com.dwalt.kodillaprojectbackend.room.Color;
import com.dwalt.kodillaprojectbackend.room.Room;
import com.dwalt.kodillaprojectbackend.room.RoomRepoService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import static com.dwalt.kodillaprojectbackend.room.Color.*;

@Component
public class Start {
    public Start(RoomRepoService roomRepoService, ReservationRepoService reservationRepoService) {
        Random random = new Random();
        Room room1 = Room.builder()
                .capacity(5)
                .color(RED)
                .title("Room 1")
                .description("Description for room 1")
                .imageUrl("https://picsum.photos/200/300?random=" + random.nextInt(100))
                .pricePerDay(120)
                .reservations(new ArrayList<>())
                .build();
        Room room2 = Room.builder()
                .capacity(5)
                .color(GREEN)
                .title("Room 2")
                .description("Description for room 2")
                .imageUrl("https://picsum.photos/200/300?random=" + random.nextInt(100))
                .pricePerDay(120)
                .reservations(new ArrayList<>())
                .build();

        Room room3 = Room.builder()
                .capacity(5)
                .color(BLUE)
                .title("Room 3")
                .description("Description for room 3")
                .imageUrl("https://picsum.photos/200/300?random=" + random.nextInt(100))
                .pricePerDay(120)
                .reservations(new ArrayList<>())
                .build();

        Room room4 = Room.builder()
                .capacity(5)
                .color(PURPLE)
                .title("Room 4")
                .description("Description for room 4")
                .imageUrl("https://picsum.photos/200/300?random=" + random.nextInt(100))
                .pricePerDay(120)
                .reservations(new ArrayList<>())
                .build();

        Room room5 = Room.builder()
                .capacity(5)
                .color(ORANGE)
                .title("Room 5")
                .description("Description for room 5")
                .imageUrl("https://picsum.photos/200/300?random=" + random.nextInt(100))
                .pricePerDay(120)
                .reservations(new ArrayList<>())
                .build();

        Reservation reservation1 = Reservation.builder()
                .fromDate(LocalDate.now().plusDays(20))
                .toDate(LocalDate.now().plusDays(27))
                .build();

        /*roomRepoService.add(room1);
        roomRepoService.add(room2);
        roomRepoService.add(room3);
        roomRepoService.add(room4);
        roomRepoService.add(room5);*/

        /*Reservation reservation =
                Reservation.builder()
                        .fromDate(LocalDate.now().plusDays(20))
                        .toDate(LocalDate.now().plusDays(27))
                        .room(roomRepoService.findById(1L).get())
                        .build();

        reservationRepoService.add(reservation);*/


       /* Room roomById = roomRepoService.findRoomById(3L).get();
        List<Room> rooms = new ArrayList<>();
        rooms.add(roomById);
        reservation1.setRooms(rooms);

        reservationRepoService.addReservation(reservation1);*/
        //reservationRepoService.addReservation(reservation1);



    }
}
