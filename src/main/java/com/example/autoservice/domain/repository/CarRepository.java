package com.example.autoservice.domain.repository;

import com.example.autoservice.domain.model.Car;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarRepository {
    List<Car> getCars();
    Car getCarById(UUID id);
    void save(Car car);
    void removeById(UUID id);
}
