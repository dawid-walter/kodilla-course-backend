package com.dwalt.kodillaprojectbackend.fixtures;

import com.dwalt.kodillaprojectbackend.reservation.ReservationDto;
import com.dwalt.kodillaprojectbackend.room.Color;
import com.dwalt.kodillaprojectbackend.room.RoomDto;
import lombok.AccessLevel;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

@Getter
public class DtoFixtures {
    @Getter(value = AccessLevel.NONE)
    private final Random random = new Random();
    private final RoomDto roomDto;
    private final ReservationDto reservationDto;

    public DtoFixtures() {
        roomDto = RoomDto.builder()
                .capacity(5)
                .color(Color.RED)
                .title("Test")
                .description("Test Description")
                .imageUrl("https://picsum.photos/200/300?random=" + random.nextInt(100))
                .pricePerDay(120)
                .reservations(new ArrayList<>()).build();
        reservationDto = ReservationDto.builder()
                .id(1L)
                .fromDate(LocalDate.now().plusDays(20))
                .toDate(LocalDate.now().plusDays(27))
                .roomId(roomDto.getId())
                .build();
    }
}
