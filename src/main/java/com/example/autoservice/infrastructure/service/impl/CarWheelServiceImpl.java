package com.example.autoservice.infrastructure.service.impl;

import com.example.autoservice.appservice.CarWheelService;
import com.example.autoservice.domain.model.CarWheel;
import com.example.autoservice.domain.repository.CarWheelRepository;
import com.example.autoservice.handler.exceptions.ProductNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarWheelServiceImpl implements CarWheelService {

    private final CarWheelRepository carWheelRepository;

    @Autowired
    public CarWheelServiceImpl(CarWheelRepository carWheelRepository) {
        this.carWheelRepository = carWheelRepository;
    }

    @Transactional
    @Override
    public List<CarWheel> getCarWheels() {
        return carWheelRepository.getCarWheels();
    }

    @Transactional
    @Override
    public CarWheel getCarWheelById(UUID id) {
        if (carWheelRepository.getCarWheelById(id) == null) {
            throw new ProductNotFoundException("Car tire id not found");
        } else {
            return carWheelRepository.getCarWheelById(id);
        }
    }

    @Transactional
    @Override
    public CarWheel save(CarWheel carWheel) {
        carWheelRepository.save(carWheel);
        return carWheel;
    }

    @Transactional
    @Override
    public void removeById(UUID id) {
        carWheelRepository.removeById(id);
    }
}
