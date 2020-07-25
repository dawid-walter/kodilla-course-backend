package com.dwalt.kodillaprojectbackend.room;

import com.dwalt.kodillaprojectbackend.reservation.Reservation;
import com.dwalt.kodillaprojectbackend.reservation.ReservationDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final RoomRepoService roomRepoService;
    private final RoomMapper roomMapper;

    @GetMapping
    public ResponseEntity<List<RoomDto>> getRooms() {
        List<Room> rooms = roomRepoService.findAll();

        if (rooms != null) {
            return new ResponseEntity<>(roomMapper.mapToRoomDtoList(rooms), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDto> getById(@PathVariable Long id) {
        Optional<Room> roomById = roomRepoService.findById(id);
return new ResponseEntity(roomMapper.mapToRoomDto(roomById.get()), HttpStatus.OK);
        /*
        return roomById.map(room ->
                new ResponseEntity<>(roomMapper.mapToRoomDto(room),
                        HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
*/
    }
}



