package com.dwalt.kodillaprojectbackend.reservationTests;/*
package com.dwalt.kodillaprojectback.reservationTests;

import com.dwalt.kodillaprojectback.reservation.ReservationDto;
import com.dwalt.kodillaprojectback.reservation.ReservationController;
import com.dwalt.kodillaprojectback.reservation.ReservationRepoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ReservationController.class)
public class ReservationDtoControllerTest {
    private ReservationDto reservationDtoFixture;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ReservationRepoService repoService;

    @BeforeEach
    public void setup() {
        reservationDtoFixture = new ReservationDto(1L, LocalDate.now().minusDays(20), LocalDate.now().minusDays(10), null, null, 0);
    }

    @Test
    public void should_Get_Empty_Reservations_List() throws Exception {
        //Given
        List<ReservationDto> reservationDtos = new ArrayList<>();
        when(repoService.getAllReservations()).thenReturn(reservationDtos);

        //When&Then
        mockMvc.perform(get("/reservations").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void should_GetReservations_List() throws Exception {
        //Given
        List<ReservationDto> reservationDtos = new ArrayList<>();
        reservationDtos.add(reservationDtoFixture);
        when(repoService.getAllReservations()).thenReturn(reservationDtos);

        //When&Then
        mockMvc.perform(get("/reservations").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    public void should_Get_Reservation_By_Id() throws Exception {
        //Given
        Long id = reservationDtoFixture.getId();
        when(repoService.findReservationById(id)).thenReturn(Optional.of(reservationDtoFixture));

        //When&Then
        mockMvc.perform(get("/reservations/" + id).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id", is(id.intValue())))
                .andExpect(jsonPath("$.color", is("RED")));
    }

    @Test
    public void should_Add_New_Reservation() throws Exception {
        //Given
        Long id = reservationDtoFixture.getId();
        when(repoService.findReservationById(id)).thenReturn(Optional.of(reservationDtoFixture));

        //When&Then
        mockMvc.perform(get("/reservations/" + id).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id", is(id.intValue())))
                .andExpect(jsonPath("$.color", is("RED")));
    }

    @Test
    public void is_Reservation_Available() {
        //Given
        List<ReservationDto> reservationDtoList = new ArrayList<>();
        reservationDtoList.add(reservationDtoFixture);
        when(repoService.getAllReservations()).thenReturn(reservationDtoList);

        //When
    }

    @Test
    public void is_Reservation_Booked() {

    }
}
*/
