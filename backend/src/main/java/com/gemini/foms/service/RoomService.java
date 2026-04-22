package com.gemini.foms.service;

import com.gemini.foms.entity.Room;
import com.gemini.foms.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository repo;

    public Room create(Room room) {
        if(repo.findByRoomNumber(room.getRoomNumber()) == null ) {
            room.setAvailable(true);
            return repo.save(room);
        }else{
            throw new RuntimeException("Room already exists.");
        }
    }

    public List<Room> getAvailableRooms() {
        return repo.findByAvailableTrue();
    }

    public List<Room> getAll() {
        return repo.findAll();
    }
}
