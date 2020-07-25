package com.dwalt.kodillaprojectbackend.reservation;

import com.dwalt.kodillaprojectbackend.room.Room;
import com.dwalt.kodillaprojectbackend.room.RoomDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ReservationMapper {
    public Reservation mapToReservation(final ReservationDto reservationDto) {
        return Reservation.builder()
                .fromDate(reservationDto.getFromDate())
                .toDate(reservationDto.getToDate())
                .build();
    }

    public ReservationDto mapToReservationDto(final Reservation reservation) {
        return ReservationDto.builder()
                .id(reservation.getId())
                .fromDate(reservation.getFromDate())
                .toDate(reservation.getToDate())
                .build();
    }

    public List<ReservationDto> mapToReservationDtoList(List<Reservation> reservations) {
        return reservations.stream()
                .map(reservation ->
                        ReservationDto.builder()
                                .id(reservation.getId())
                                .fromDate(reservation.getFromDate())
                                .toDate(reservation.getToDate())
                                .build()
                )
                .collect(Collectors.toList());
    }

    public List<Reservation> mapToReservationList(List<ReservationDto> reservationsDto) {
        return reservationsDto.stream()
                .map(reservation ->
                        Reservation.builder()
                                .id(reservation.getId())
                                .fromDate(reservation.getFromDate())
                                .toDate(reservation.getToDate())
                                .build()
                )
                .collect(Collectors.toList());
    }
}
