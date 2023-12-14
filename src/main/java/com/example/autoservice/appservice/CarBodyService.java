package com.example.autoservice.appservice;

import com.example.autoservice.domain.model.CarBody;

import java.util.List;
import java.util.UUID;

public interface CarBodyService {
    List<CarBody> getCarBodies();

    CarBody getCarBodyById(UUID id);

    CarBody save(CarBody carBody);

    void removeById(UUID id);
}
