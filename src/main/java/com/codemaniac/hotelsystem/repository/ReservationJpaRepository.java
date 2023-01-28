package com.codemaniac.hotelsystem.repository;

import com.codemaniac.hotelsystem.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationJpaRepository extends JpaRepository<Reservation, Long>, ReservationRepository {
}
