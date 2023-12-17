package com.example.autoservice.domain.repository;

import com.example.autoservice.domain.model.CarBody;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarBodyRepository {
    List<CarBody> getBodyCars();
    CarBody getCarBodyById(UUID id);
    void save(CarBody carBody);
    void removeById(UUID id);
}
