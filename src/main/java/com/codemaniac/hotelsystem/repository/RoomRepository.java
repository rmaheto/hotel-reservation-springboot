package com.codemaniac.hotelsystem.repository;

import com.codemaniac.hotelsystem.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {
}
