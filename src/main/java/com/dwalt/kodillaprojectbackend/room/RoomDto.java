package com.dwalt.kodillaprojectbackend.room;

import com.dwalt.kodillaprojectbackend.reservation.ReservationDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

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
}
