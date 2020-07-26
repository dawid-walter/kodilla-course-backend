package com.dwalt.kodillaprojectbackend.room;

import com.dwalt.kodillaprojectbackend.reservation.ReservationDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@RequiredArgsConstructor
@Getter
@ToString
@Builder
public class RoomDto {
    private final Long id;
    private final Color color;
    private final String title;
    private final String description;
    private final int capacity;
    private final String imageUrl;
    private final double pricePerDay;

    private final List<ReservationDto> reservations;

    public boolean isAvailable(LocalDate from, LocalDate to) {
        AtomicBoolean isAvailable = new AtomicBoolean(true);
        reservations.forEach(reservation -> {
            if (from.isBefore(reservation.getToDate()) && to.isAfter(reservation.getFromDate()))
                isAvailable.set(false);
        });
        return isAvailable.get();
    }
}
