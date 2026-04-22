package com.gemini.foms.controller;

import com.gemini.foms.entity.Room;
import com.gemini.foms.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@CrossOrigin(origins = "*")
public class RoomController {

    @Autowired
    private RoomService service;

    @PostMapping
    public Room create(@RequestBody Room room) {
        return service.create(room);
    }

    @GetMapping
    public List<Room> getAll() {
        return service.getAll();
    }

    @GetMapping("/available")
    public List<Room> available() {
        return service.getAvailableRooms();
    }
}
