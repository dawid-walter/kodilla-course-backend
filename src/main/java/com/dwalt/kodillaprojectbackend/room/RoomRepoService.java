package com.dwalt.kodillaprojectbackend.room;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

@RequiredArgsConstructor
@Service
public class RoomRepoService {
    private final Logger log = LoggerFactory.getLogger(RoomRepoService.class);
    private final RoomRepo roomRepo;

    public Room add(Room room) {
        //log.info("Object {} Added to database, on : {}", room, LocalDateTime.now());
        return roomRepo.save(room);
    }

    public List<Room> findAll() {
        return roomRepo.findAll();
    }

    public Optional<Room> findById(Long id) {
        return roomRepo.findById(id);
    }

    public void deleteById(Long id) {
        log.info("Object {} deleted from database, on : {}", roomRepo.findById(id), LocalDateTime.now());
        roomRepo.deleteById(id);
    }

    public Optional<Room> findRoomByTitle(String title) {
        return roomRepo.findByTitle(title);
    }

    @Transactional
    public Optional<Room> update(RoomDto room) {
        Optional<Room> byId = roomRepo.findById(room.getId());

        byId.get().setColor(room.getColor());
        byId.get().setTitle(room.getTitle());
        byId.get().setDescription(room.getDescription());
        byId.get().setCapacity(room.getCapacity());
        byId.get().setImageUrl(room.getImageUrl());
        byId.get().setPricePerDay(room.getPricePerDay());
        return byId;
    }
}
