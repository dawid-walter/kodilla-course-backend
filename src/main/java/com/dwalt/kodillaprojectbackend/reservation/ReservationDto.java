package com.dwalt.kodillaprojectbackend.reservation;

import com.dwalt.kodillaprojectbackend.room.RoomDto;
import com.dwalt.kodillaprojectbackend.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Getter
@ToString
@Builder
public class ReservationDto {
    private final Long id;
    private final LocalDate fromDate;
    private final LocalDate toDate;
    private final User user;
    private final List<RoomDto> dtoRooms;
}
