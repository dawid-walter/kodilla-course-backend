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

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ReservationRepoServiceTest {
    private EntityFixtures entityFixtures = new EntityFixtures();
    private Room roomFixture;
    private Reservation reservationFixture;

    @Autowired
    RoomRepoService roomRepoService;
    @Autowired
    ReservationRepoService reservationRepoService;

    @BeforeEach
    void setUp() {
        roomFixture = entityFixtures.getRoomFixture();
        reservationFixture = entityFixtures.getReservationFixture();
    }

    @Test
    @DisplayName("Test getting empty list of reservations from database")
    public void should_get_empty_list_of_reservations_from_database() {
        assertThat(reservationRepoService.findAll().size()).isEqualTo(0);
    }

    @Test
    @DisplayName("Test adding reservation to database")
    public void should_add_reservation_to_database() {
        reservationRepoService.add(reservationFixture);

        assertThat(reservationRepoService.findAll().size()).isEqualTo(1);

        reservationRepoService.deleteById(reservationFixture.getId());
    }

    @Transactional
    @Test
    @DisplayName("Test adding room to reservation in database")
    public void should_add_room_to_reservation_in_database() {
        roomRepoService.add(roomFixture);

        reservationRepoService.add(reservationFixture);
        Long id = reservationFixture.getId();

        reservationFixture.setRoom(roomFixture);

        assertThat(reservationRepoService.findById(id).get().getRoom().getTitle()).isEqualTo("Room 1");

        reservationRepoService.deleteById(id);
    }

    @Test
    @DisplayName("Test removing reservation from database")
    public void should_remove_reservation_from_database() {
        reservationRepoService.add(reservationFixture);
        Long id = reservationFixture.getId();
        reservationRepoService.deleteById(id);

        assertThat(reservationRepoService.findAll().size()).isEqualTo(0);
    }

}
