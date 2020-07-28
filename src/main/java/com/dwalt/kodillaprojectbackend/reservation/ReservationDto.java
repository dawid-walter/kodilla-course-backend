package com.dwalt.kodillaprojectbackend.reservation;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
@ToString
@Builder
public class ReservationDto {
    private final Long id;
    private final LocalDate fromDate;
    private final LocalDate toDate;
    //private final User user;
    private final Long roomId;
}
