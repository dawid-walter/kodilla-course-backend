package com.dwalt.kodillaprojectbackend.room;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RoomRepoService {
    private final Logger log = LoggerFactory.getLogger(RoomRepoService.class);
    private final RoomRepo roomRepo;

    public Room add(Room room) {
        log.info("Object {} Added to database, on : {}", room, LocalDateTime.now());
        return roomRepo.save(room);
    }

    public List<Room> findAll() {
        return roomRepo.findAll();
    }

    public Optional<Room> findById(Long id) {
        //log.info("Object {} obtained from database, on : {}", roomRepo.findById(id), LocalDateTime.now());
        return roomRepo.findById(id);
    }

    public void deleteById(Long id) {
        log.info("Object {} Added to database, on : {}", roomRepo.findById(id), LocalDateTime.now());
        roomRepo.deleteById(id);
    }
}
