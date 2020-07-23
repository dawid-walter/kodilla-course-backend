package com.dwalt.kodillaprojectbackend.reservation;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);
    private final ReservationRepoService reservationRepoService;
    private final ReservationMapper reservationMapper;

    @GetMapping
    public ResponseEntity<List<ReservationDto>> getAll() {
        List<ReservationDto> reservationDtos = reservationMapper.mapToReservationDtoList(reservationRepoService.getAllReservations());
        if (reservationDtos != null) {
            return new ResponseEntity<>(reservationDtos, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDto> getById(@PathVariable Long id) {
        Optional<Reservation> reservationById = reservationRepoService.findReservationById(id);
        return reservationById.map(reservation ->
                new ResponseEntity<>(reservationMapper.mapToReservationDto(reservation),
                        HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ReservationDto> add(@RequestBody ReservationDto reservationDto) {
        Reservation reservation = reservationRepoService.addReservation(reservationMapper.mapToReservation(reservationDto));
        LOGGER.info("Object {} Added to database, on : {}", reservationDto.getClass().getName(), LocalDateTime.now());
        return new ResponseEntity<>(reservationMapper.mapToReservationDto(reservation), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<ReservationDto> delete(Long id) {
        Optional<Reservation> reservationById = reservationRepoService.findReservationById(id);
        if (reservationById.isPresent()) {
            reservationRepoService.deleteById(id);
            LOGGER.info("Object {} deleted from database, on : {}", reservationById.getClass().getName(), LocalDateTime.now());
            return new ResponseEntity<>(reservationMapper.mapToReservationDto(reservationById.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

