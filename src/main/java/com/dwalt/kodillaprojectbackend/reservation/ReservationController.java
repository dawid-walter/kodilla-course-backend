package com.dwalt.kodillaprojectbackend.reservation;

import com.dwalt.kodillaprojectbackend.room.Room;
import com.dwalt.kodillaprojectbackend.room.RoomDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @GetMapping("/room")
    public ResponseEntity<List<ReservationDto>> getByRoom(@RequestParam Long id) {
        List<ReservationDto> reservationDtos = reservationMapper.mapToReservationDtoList(reservationRepoService.findAll());
        if (!reservationDtos.isEmpty()) {
            return new ResponseEntity<>(reservationDtos.stream()
                    .filter(reservationDto -> reservationDto.getRoomId().equals(id))
                    .collect(Collectors.toList())
                    , HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ReservationDto> add(@RequestBody ReservationDto reservationDto) {
        Reservation reservation = reservationRepoService.addDto(reservationDto);
        return new ResponseEntity<>(reservationMapper.mapToReservationDto(reservation), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReservationDto> delete(@PathVariable Long id) {
        Optional<Reservation> reservationById = reservationRepoService.findById(id);
        if (reservationById.isPresent()) {
            reservationRepoService.deleteById(id);
            return new ResponseEntity<>(reservationMapper.mapToReservationDto(reservationById.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<ReservationDto> update(@RequestBody ReservationDto reservation) {
        Optional<Reservation> byId = reservationRepoService.update(reservation);
        return byId.map(value -> new ResponseEntity<>(reservationMapper.mapToReservationDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
