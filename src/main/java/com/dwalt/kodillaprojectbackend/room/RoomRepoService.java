package com.dwalt.kodillaprojectbackend.room;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RoomRepoService {
    private final RoomRepo roomRepo;

    public Room addRoom(Room room) {
        return roomRepo.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepo.findAll();
    }

    public Optional<Room> findRoomById(Long id) {
        return roomRepo.findById(id);
    }

    public void deleteById(Long id) {
        roomRepo.deleteById(id);
    }
}
