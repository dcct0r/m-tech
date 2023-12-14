package com.example.autoservice.infrastructure.service.impl;

import com.example.autoservice.appservice.CarBodyService;
import com.example.autoservice.domain.model.CarBody;
import com.example.autoservice.domain.repository.CarBodyRepository;
import com.example.autoservice.handler.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class CarBodyServiceImpl implements CarBodyService {

    private final CarBodyRepository carBodyRepository;

    @Autowired
    public CarBodyServiceImpl(CarBodyRepository carBodyRepository) {
        this.carBodyRepository = carBodyRepository;
    }

    @Transactional
    @Override
    public List<CarBody> getCarBodies() {
        return carBodyRepository.getBodyCars();
    }

    @Transactional
    @Override
    public CarBody getCarBodyById(UUID id) {
        if(carBodyRepository.getCarBodyById(id) == null) {
            throw new ProductNotFoundException("Car body id not found");
        } else {
            return carBodyRepository.getCarBodyById(id);
        }
    }

    @Transactional
    @Override
    public CarBody save(CarBody carBody) {
        carBodyRepository.save(carBody);
        return carBody;
    }

    @Transactional
    @Override
    public void removeById(UUID id) {
        carBodyRepository.removeById(id);
    }

}
