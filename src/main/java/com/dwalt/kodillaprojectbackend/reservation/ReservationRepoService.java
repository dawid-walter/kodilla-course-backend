package com.dwalt.kodillaprojectbackend.reservation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReservationRepoService {
    private final ReservationRepo reservationRepo;

    public Reservation addReservation(Reservation reservation) {
        return reservationRepo.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepo.findAll();
    }

    public Optional<Reservation> findReservationById(Long id) {
        return reservationRepo.findById(id);
    }

    public void deleteById(Long id) {
        reservationRepo.deleteById(id);
    }
}
