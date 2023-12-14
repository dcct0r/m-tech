package com.example.autoservice.domain.repository;

import com.example.autoservice.domain.model.CarBody;

import java.util.List;
import java.util.UUID;

public interface CarBodyRepository {
    List<CarBody> getBodyCars();
    CarBody getCarBodyById(UUID id);
    void save(CarBody carBody);
    void removeById(UUID id);
}
