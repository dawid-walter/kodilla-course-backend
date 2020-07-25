package com.dwalt.kodillaprojectbackend.reservation;

import com.dwalt.kodillaprojectbackend.room.RoomDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationRepoService reservationRepoService;
    private final ReservationMapper reservationMapper;

    @GetMapping
    public ResponseEntity<List<ReservationDto>> getAll() {
        List<ReservationDto> reservationDtos = reservationMapper.mapToReservationDtoList(reservationRepoService.findAll());
        if (reservationDtos != null) {
            return new ResponseEntity<>(reservationDtos, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDto> getById(@PathVariable Long id) {
        Optional<Reservation> reservationById = reservationRepoService.findById(id);
        return reservationById.map(reservation ->
                new ResponseEntity<>(reservationMapper.mapToReservationDto(reservation),
                        HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ReservationDto> add(@RequestBody ReservationDto reservationDto) {
        System.out.println(reservationDto);
        Reservation reservation = reservationRepoService.addDto(reservationDto);
        return new ResponseEntity<>(reservationMapper.mapToReservationDto(reservation), HttpStatus.CREATED);
    }
    @PostMapping("/test")
    public ResponseEntity<ReservationDto> addTest(@RequestBody ReservationDto reservationDto) {
        Reservation reservation = reservationRepoService.add(reservationMapper.mapToReservation(reservationDto));
        return new ResponseEntity<>(reservationMapper.mapToReservationDto(reservation), HttpStatus.CREATED);
    }

    /*@PostMapping
    public ResponseEntity<ReservationDto> add(@RequestBody ReservationDto reservationDto, @RequestParam Long roomId) {
        Reservation reservation = reservationRepoService.addWithRoom(reservationMapper.mapToReservation(reservationDto), roomId);
        return new ResponseEntity<>(reservationMapper.mapToReservationDto(reservation), HttpStatus.CREATED);
    }*/

    @DeleteMapping
    public ResponseEntity<ReservationDto> delete(Long id) {
        Optional<Reservation> reservationById = reservationRepoService.findById(id);
        if (reservationById.isPresent()) {
            reservationRepoService.deleteById(id);
            return new ResponseEntity<>(reservationMapper.mapToReservationDto(reservationById.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public void addRoomsToReservation(@PathVariable Long id, @RequestBody List<RoomDto> roomsDto) {

    }
}

