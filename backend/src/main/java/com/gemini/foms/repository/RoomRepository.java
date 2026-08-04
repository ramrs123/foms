package com.gemini.foms.repository;

import com.gemini.foms.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByAvailableTrue();
    boolean existsByRoomNo(String roomNo);
    Optional<Room> findFirstByAvailableTrueOrderByRoomNoAsc();
}
