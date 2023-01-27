package com.codemaniac.hotelsystem.repository;

import com.codemaniac.hotelsystem.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Long> {
}
