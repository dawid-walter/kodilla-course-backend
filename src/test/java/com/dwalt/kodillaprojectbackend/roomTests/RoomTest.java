package com.dwalt.kodillaprojectbackend.roomTests;

import com.dwalt.kodillaprojectbackend.reservation.ReservationDto;
import com.dwalt.kodillaprojectbackend.room.RoomDto;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RoomTest {
    @Test
    public void is_room_available_in_dates() {
        List<ReservationDto> reservations = new ArrayList<>();
        reservations.add(ReservationDto.builder()
                .fromDate(LocalDate.now())
                .toDate(LocalDate.now().plusDays(1))
                .build());

        RoomDto room = RoomDto.builder()
                .reservations(reservations)
                .build();

        assertThat(room.isAvailable(LocalDate.now(), LocalDate.now().plusDays(1))).isFalse();
        assertThat(room.isAvailable(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1))).isFalse();
        assertThat(room.isAvailable(LocalDate.now().minusDays(2), LocalDate.now().plusDays(2))).isFalse();
        assertThat(room.isAvailable(LocalDate.now().plusDays(10), LocalDate.now().plusDays(15))).isTrue();
        assertThat(room.isAvailable(LocalDate.now().plusDays(1), LocalDate.now().plusDays(12))).isTrue();
    }

    @Test
    public void is_room_is_available_in_dates_when_reservations_list_is_empty() {
        List<ReservationDto> reservations = new ArrayList<>();

        RoomDto room = RoomDto.builder()
                .reservations(reservations)
                .build();

        assertThat(room.isAvailable(LocalDate.now(), LocalDate.now().plusDays(1))).isTrue();
    }
}
