package com.dwalt.kodillaprojectbackend.roomTests;

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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RoomRepoServiceTest {
    EntityFixtures entityFixtures = new EntityFixtures();
    private Room roomFixture;
    private Reservation reservationFixture;
    private List<Reservation> reservationsFixture;

    @Autowired
    RoomRepoService roomRepoService;
    @Autowired
    ReservationRepoService reservationRepoService;

    @BeforeEach
    void setUp() {
        roomFixture = entityFixtures.getRoomFixture();
        reservationFixture = entityFixtures.getReservationFixture();
        reservationsFixture = entityFixtures.getReservationsFixture();
    }

    @Test
    @DisplayName("Test getting empty list of rooms from database")
    public void should_get_empty_list_of_rooms() {
        assertThat(roomRepoService.getAllRooms().size()).isEqualTo(0);
    }

    @Test
    @DisplayName("Test adding room to database")
    public void should_add_room() {
        roomRepoService.addRoom(roomFixture);

        assertThat(roomRepoService.getAllRooms().size()).isEqualTo(1);

        roomRepoService.deleteById(roomFixture.getId());
    }

    @Transactional
    @Test
    @DisplayName("Test adding reservation to room in database")
    public void should_add_reservation_to_room() {
        reservationRepoService.addReservation(reservationFixture);
        Long id = roomFixture.getId();

        roomRepoService.addRoom(roomFixture);
        reservationsFixture.add(reservationFixture);
        roomFixture.setReservations(reservationsFixture);

        assertThat(roomRepoService.findRoomById(id).get().getReservations().size()).isEqualTo(1);

        roomRepoService.deleteById(id);
    }

    @Test
    @DisplayName("Test removing room from database")
    public void should_remove_room_from_database() {
        roomRepoService.addRoom(roomFixture);
        Long id = roomFixture.getId();
        roomRepoService.deleteById(id);

        assertThat(roomRepoService.getAllRooms().size()).isEqualTo(0);
    }
}
