package com.dwalt.kodillaprojectbackend.room;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final RoomRepoService roomRepoService;
    private final RoomMapper roomMapper;

    @GetMapping
    public ResponseEntity<List<RoomDto>> get() {
        List<Room> rooms = roomRepoService.findAll();
        if (rooms != null) {
            return new ResponseEntity<>(roomMapper.mapToRoomDtoList(rooms), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDto> getById(@PathVariable Long id) {
        Optional<Room> roomById = roomRepoService.findById(id);
        return roomById.map(room ->
                new ResponseEntity<>(roomMapper.mapToRoomDto(room),
                        HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @GetMapping("/inDates")
    public ResponseEntity<List<RoomDto>> getAvailable(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                                      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        List<RoomDto> availableRooms = roomMapper.mapToRoomDtoList(roomRepoService.findAll())
                .stream()
                .filter(room -> room.isAvailable(from, to))
                .collect(Collectors.toList());
        if (!availableRooms.isEmpty()) {
            return new ResponseEntity<>(availableRooms, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}



