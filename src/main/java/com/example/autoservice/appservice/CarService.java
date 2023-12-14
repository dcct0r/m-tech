package com.example.autoservice.appservice;

import com.example.autoservice.domain.model.Car;

import java.util.List;
import java.util.UUID;

public interface CarService {
    List<Car> getCars();

    Car getCarById(UUID id);

    Car save(Car car);

    void removeById(UUID id);
}
