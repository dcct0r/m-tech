package com.example.autoservice.domain.repository;


import com.example.autoservice.domain.model.CarWheel;

import java.util.List;
import java.util.UUID;

public interface CarWheelRepository {
    List<CarWheel> getCarWheels();
    CarWheel getCarWheelById(UUID id);
    void save(CarWheel carWheel);
    void removeById(UUID id);
}
