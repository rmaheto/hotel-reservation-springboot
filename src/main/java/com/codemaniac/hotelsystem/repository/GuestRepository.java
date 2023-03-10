package com.codemaniac.hotelsystem.repository;

import com.codemaniac.hotelsystem.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest,Long> {
}
