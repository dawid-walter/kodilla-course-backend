package com.dwalt.kodillaprojectbackend.room;

import com.dwalt.kodillaprojectbackend.reservation.Reservation;
import com.dwalt.kodillaprojectbackend.reservation.ReservationDto;
import com.dwalt.kodillaprojectbackend.reservation.ReservationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RoomMapper {

    public Room mapToRoom(final RoomDto roomDto) {
        return Room.builder()
                .id(roomDto.getId())
                .capacity(roomDto.getCapacity())
                .color(roomDto.getColor())
                .title(roomDto.getTitle())
                .description(roomDto.getDescription())
                .imageUrl(roomDto.getImageUrl())
                .pricePerDay(roomDto.getPricePerDay())
                .build();
    }

    public RoomDto mapToRoomDto(final Room room) {
        return RoomDto.builder()
                .id(room.getId())
                .capacity(room.getCapacity())
                .color(room.getColor())
                .title(room.getTitle())
                .description(room.getDescription())
                .imageUrl(room.getImageUrl())
                .pricePerDay(room.getPricePerDay())
                //.dtoReservations(reservationMapper.mapToReservationDtoList(room.getReservations()))
                .build();
    }



    public List<RoomDto> mapToRoomDtoList(final List<Room> rooms) {
        return rooms.stream()
                .map(room ->
                        RoomDto.builder()
                                .id(room.getId())
                                .capacity(room.getCapacity())
                                .color(room.getColor())
                                .description(room.getDescription())
                                .pricePerDay(room.getPricePerDay())
                                .imageUrl(room.getImageUrl())
                                .title(room.getTitle())
                                .build()
                )
                .collect(Collectors.toList());
    }
}
