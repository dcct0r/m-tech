package com.example.autoservice.appservice;

import com.example.autoservice.domain.model.CarWheel;

import java.util.List;
import java.util.UUID;

public interface CarWheelService {
    List<CarWheel> getCarWheels();

    CarWheel getCarWheelById(UUID id);

    CarWheel save(CarWheel carWheel);

    void removeById(UUID id);
}
