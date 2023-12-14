package com.example.autoservice.infrastructure.service.impl;

import com.example.autoservice.appservice.CarService;
import com.example.autoservice.domain.model.Car;
import com.example.autoservice.domain.repository.CarRepository;
import com.example.autoservice.handler.exceptions.ProductNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Transactional
    @Override
    public List<Car> getCars() {
        return carRepository.getCars();
    }

    @Transactional
    @Override
    public Car getCarById(UUID id) {
        if (carRepository.getCarById(id) == null) {
            throw new ProductNotFoundException("Car id not found");
        } else {
            return carRepository.getCarById(id);
        }
    }

    @Transactional
    @Override
    public Car save(Car car) {
        carRepository.save(car);
        return car;
    }

    @Transactional
    @Override
    public void removeById(UUID id) {
        carRepository.removeById(id);
    }
}
