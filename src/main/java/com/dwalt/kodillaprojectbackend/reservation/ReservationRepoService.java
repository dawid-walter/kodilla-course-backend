package com.dwalt.kodillaprojectbackend.reservation;

import com.dwalt.kodillaprojectbackend.room.Color;
import com.dwalt.kodillaprojectbackend.room.Room;
import com.dwalt.kodillaprojectbackend.room.RoomRepoService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReservationRepoService {
    private final Logger log = LoggerFactory.getLogger(ReservationRepoService.class);
    private final ReservationRepo reservationRepo;
    private final RoomRepoService roomRepo;
    private final ReservationMapper reservationMapper;

    @Transactional
    public Reservation addDto(ReservationDto reservationDto) {
        Long roomId = reservationDto.getRoomId();
        Reservation reservation = reservationMapper.mapToReservation(reservationDto);
        reservation.setRoom(roomRepo.findById(roomId).get());
        log.info("Object {} Added to database, on : {}", reservationDto, LocalDateTime.now());
        return reservationRepo.save(reservation);
    }

    public Reservation add(Reservation reservation) {
        return reservationRepo.save(reservation);
    }

    public Reservation addWithRoom(Reservation reservation, Long roomId) {
        log.info("Object {} Added to database, on : {}", reservation, LocalDateTime.now());
        reservation.setRoom(roomRepo.findById(roomId).get());
        return reservationRepo.save(reservation);
    }

    public List<Reservation> findAll() {
        return reservationRepo.findAll();
    }

    public Optional<Reservation> findById(Long id) {
        return reservationRepo.findById(id);
    }

    public void deleteById(Long id) {
        log.info("Object {} deleted from database, on : {}", reservationMapper.mapToReservationDto(reservationRepo.findById(id).get()), LocalDateTime.now());
        reservationRepo.deleteById(id);
    }

    @Transactional
    public Optional<Reservation> update(ReservationDto reservation) {
        Room room = roomRepo.findById(reservation.getRoomId()).get();
        Optional<Reservation> byId = reservationRepo.findById(reservation.getId());
        byId.get().setFromDate(reservation.getFromDate());
        byId.get().setToDate(reservation.getToDate());
        byId.get().setRoom(room);
        return byId;
    }


}
