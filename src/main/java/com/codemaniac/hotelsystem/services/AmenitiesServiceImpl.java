package com.codemaniac.hotelsystem.services;

import com.codemaniac.hotelsystem.entities.Amenities;
import com.codemaniac.hotelsystem.repository.AmenitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmenitiesServiceImpl implements AmenitiesService{

    @Autowired
    private AmenitiesRepository amenitiesRepository;

    @Override
    public Amenities getAmenities(long amenitiesId) {
        return amenitiesRepository.findById(amenitiesId).orElse(null);
    }

    @Override
    public List<Amenities> getAllAmenities() {
        return amenitiesRepository.findAll();
    }

    @Override
    public Amenities createAmenities(Amenities amenities) {
        return amenitiesRepository.save(amenities);
    }

    @Override
    public Amenities updateAmenities(long amenitiesId, Amenities amenities) {
        Amenities existingAmenities = amenitiesRepository.findById(amenitiesId).orElse(null);
        if(existingAmenities != null) {
            existingAmenities.setDescription(amenities.getDescription());
            return amenitiesRepository.save(existingAmenities);
        }
        return null;
    }

    @Override
    public void deleteAmenities(long amenitiesId) {
        amenitiesRepository.deleteById(amenitiesId);
    }
}
