package com.dwalt.kodillaprojectbackend.room;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoomMapper {
    public List<RoomDto> mapToRoomDtoList(List<Room> rooms) {
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
