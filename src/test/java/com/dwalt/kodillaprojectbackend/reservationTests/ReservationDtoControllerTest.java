/*
package com.dwalt.kodillaprojectbackend.reservationTests;

import com.dwalt.kodillaprojectbackend.fixtures.DtoFixtures;
import com.dwalt.kodillaprojectbackend.reservation.ReservationController;
import com.dwalt.kodillaprojectbackend.reservation.ReservationDto;
import com.dwalt.kodillaprojectbackend.room.RoomDto;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReservationController.class)
public class ReservationDtoControllerTest {
    private DtoFixtures dtoFixtures = new DtoFixtures();
    private RoomDto roomDtoFixture;
    private ReservationDto reservationDtoFixture;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ReservationController reservationController;


    @BeforeEach
    public void setup() {
        reservationDtoFixture = dtoFixtures.getReservationDto();
        roomDtoFixture = dtoFixtures.getRoomDto();
    }

    @Test
    @DisplayName("Test getting empty reservations list")
    public void should_Get_Empty_Reservations_List() throws Exception {
        //Given
        List<ReservationDto> reservationDtos = new ArrayList<>();
        when(reservationController.getAll()).thenReturn(new ResponseEntity<>(reservationDtos, HttpStatus.OK));

        //When&Then
        mockMvc.perform(get("/reservations").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    @DisplayName("Test getting all reservations")
    public void should_GetReservations_List() throws Exception {
        //Given
        List<ReservationDto> reservationDtos = new ArrayList<>();
        reservationDtos.add(reservationDtoFixture);
        when(reservationController.getAll()).thenReturn(new ResponseEntity<>(reservationDtos, HttpStatus.OK));

        //When&Then
        mockMvc.perform(get("/reservations").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    @DisplayName("Test getting reservation by id")
    public void should_Get_Reservation_By_Id() throws Exception {
        //Given
        Long id = reservationDtoFixture.getId();
        when(reservationController.getById(id)).thenReturn(new ResponseEntity<>(reservationDtoFixture, HttpStatus.OK));

        //When&Then
        mockMvc.perform(get("/reservations/" + id).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id", is(id.intValue())));
    }

    @Test
    @DisplayName("Test adding new reservation")
    public void should_Add_New_Reservation() throws Exception {
        //Given
        Gson gson = new Gson();
        String jsonContent = gson.toJson(reservationDtoFixture);

        //When&Then
        mockMvc.perform(post("/reservations").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8").content(jsonContent))
                .andExpect(status().is(200));
    }

}

*/
