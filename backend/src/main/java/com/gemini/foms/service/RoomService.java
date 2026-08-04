package com.gemini.foms.service;

import com.gemini.foms.entity.Room;
import com.gemini.foms.exception.DuplicateRoomException;
import com.gemini.foms.repository.RoomRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {

        this.roomRepository = roomRepository;
    }

    public Room create(Room room){

        room.setRoomNo(room.getRoomNo().trim());

        if(roomRepository.existsByRoomNo(room.getRoomNo())){

            throw new DuplicateRoomException(
                    "Room already exists.");

        }

        room.setAvailable(true);

        return roomRepository.save(room);

    }

    public List<Room> getAll(){

        return roomRepository.findAll();

    }
    public List<Room> getAvailableRooms(){
        return roomRepository.findByAvailableTrue();
    }

}