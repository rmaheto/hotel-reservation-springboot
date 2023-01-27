package com.codemaniac.hotelsystem.repository;

import com.codemaniac.hotelsystem.entities.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {
}
