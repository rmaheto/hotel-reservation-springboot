package com.codemaniac.hotelsystem.services;

import com.codemaniac.hotelsystem.entities.Staff;

import java.util.List;

public interface StaffService {
    public Staff getStaff(long staffId);
    public List<Staff> getAllStaff();
    public Staff createStaff(Staff staff);
    public Staff updateStaff(long staffId, Staff staff);
    public void deleteStaff(long staffId);
}
