package com.dwalt.kodillaprojectbackend.room;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final Logger LOGGER = LoggerFactory.getLogger(RoomController.class);
    private final RoomRepoService roomRepoService;
    private final RoomMapper roomMapper;

    @GetMapping
    public ResponseEntity<List<RoomDto>> getRooms() {
        List<Room> rooms = roomRepoService.getAllRooms();

        if (rooms != null) {
            return new ResponseEntity<>(roomMapper.mapToRoomDtoList(rooms), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}



