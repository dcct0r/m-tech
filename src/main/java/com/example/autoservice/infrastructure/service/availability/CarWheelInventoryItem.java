package com.example.autoservice.infrastructure.service.availability;

import com.example.autoservice.appservice.CarWheelService;
import com.example.autoservice.handler.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CarWheelInventoryItem {

    private final CarWheelService carWheelService;

    @Autowired
    public CarWheelInventoryItem(CarWheelService carWheelService) {
        this.carWheelService = carWheelService;
    }

    protected boolean isCarWheelExist(UUID id) {
        carWheelService.getCarWheelById(id);
        return true;
    }

    protected boolean isCarWheelEnough(UUID id) {
        if (carWheelService.getCarWheelById(id).getAmount() >= 2) {
            return true;
        } else {
            throw new ProductNotFoundException("Not enough car tyres");
        }
    }
}
