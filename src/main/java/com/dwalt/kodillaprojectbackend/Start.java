package com.dwalt.kodillaprojectbackend;

import com.dwalt.kodillaprojectbackend.room.Color;
import com.dwalt.kodillaprojectbackend.room.Room;
import com.dwalt.kodillaprojectbackend.room.RoomRepoService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component
public class Start {
    public Start(RoomRepoService roomRepoService) {
        Random random = new Random();
        Room room1 = Room.builder()
                .capacity(5)
                .color(Color.RED)
                .title("Pokoj 1")
                .description("Description for room 1")
                .imageUrl("https://picsum.photos/200/300?random=" + random.nextInt(100))
                .pricePerDay(120)
                .reservations(new ArrayList<>())
                .build();

        //roomRepoService.addRoom(room1);
    }
}
