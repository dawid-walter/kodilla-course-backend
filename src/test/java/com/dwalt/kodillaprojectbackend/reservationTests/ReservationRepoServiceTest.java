package com.dwalt.kodillaprojectbackend.reservationTests;

import com.dwalt.kodillaprojectbackend.fixtures.EntityFixtures;
import com.dwalt.kodillaprojectbackend.reservation.Reservation;
import com.dwalt.kodillaprojectbackend.reservation.ReservationRepoService;
import com.dwalt.kodillaprojectbackend.room.Room;
import com.dwalt.kodillaprojectbackend.room.RoomRepoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ReservationRepoServiceTest {
    private EntityFixtures entityFixtures = new EntityFixtures();
    private Room roomFixture;
    private Reservation reservationFixture;
    private List<Room> roomsFixture;

    @Autowired
    RoomRepoService roomRepoService;
    @Autowired
    ReservationRepoService reservationRepoService;

    @BeforeEach
    void setUp() {
        roomFixture = entityFixtures.getRoomFixture();
        reservationFixture = entityFixtures.getReservationFixture();
        roomsFixture = entityFixtures.getRoomsFixture();
    }

    @Test
    @DisplayName("Test getting empty list of reservations from database")
    public void should_get_empty_list_of_reservations() {
        assertEquals(0, reservationRepoService.getAllReservations().size());
    }

    @Test
    @DisplayName("Test adding reservation to database")
    public void should_add_reservation() {
        reservationRepoService.addReservation(reservationFixture);

        assertEquals(1, reservationRepoService.getAllReservations().size());

        reservationRepoService.deleteById(reservationFixture.getId());
    }

    @Transactional
    @Test
    @DisplayName("Test adding room to reservation in database")
    public void should_add_room_to_reservation() {
        reservationRepoService.addReservation(reservationFixture);
        roomRepoService.addRoom(roomFixture);
        roomsFixture.add(roomFixture);
        reservationFixture.setRooms(roomsFixture);

        Long id = reservationFixture.getId();

        assertEquals(1, reservationRepoService.findReservationById(id).get().getRooms().size());

        reservationRepoService.deleteById(id);
    }

    @Test
    @DisplayName("Test removing reservation from database")
    public void should_remove_reservation_from_database() {
        reservationRepoService.addReservation(reservationFixture);
        Long id = reservationFixture.getId();
        reservationRepoService.deleteById(id);

        assertEquals(0, reservationRepoService.getAllReservations().size());
    }
}
