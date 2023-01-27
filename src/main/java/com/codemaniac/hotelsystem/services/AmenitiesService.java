package com.codemaniac.hotelsystem.services;

import com.codemaniac.hotelsystem.entities.Amenities;

import java.util.List;

public interface AmenitiesService {
    public Amenities getAmenities(long amenitiesId);
    public List<Amenities> getAllAmenities();
    public Amenities createAmenities(Amenities amenities);
    public Amenities updateAmenities(long amenitiesId, Amenities amenities);
    public void deleteAmenities(long amenitiesId);
}
