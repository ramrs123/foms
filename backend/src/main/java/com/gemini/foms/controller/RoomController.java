package com.gemini.foms.controller;

import com.gemini.foms.entity.Room;
import com.gemini.foms.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@CrossOrigin(origins = "*")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Room create(
            @Valid
            @RequestBody Room room){

        return roomService.create(room);

    }

    @GetMapping
    public List<Room> getAll() {
        return roomService.getAll();
    }

    @GetMapping("/available")
    public List<Room> available() {
        return roomService.getAvailableRooms();
    }
}
