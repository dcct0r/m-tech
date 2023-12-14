package com.example.autoservice.infrastructure.service.availability;

import com.example.autoservice.appservice.CarBodyService;
import com.example.autoservice.handler.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CarBodyInventoryItem {

    private final CarBodyService carBodyService;

    @Autowired
    public CarBodyInventoryItem(CarBodyService carBodyService) {
        this.carBodyService = carBodyService;
    }

    protected boolean isCarBodyExist(UUID id) {
        carBodyService.getCarBodyById(id);
        return true;
    }

    protected boolean isCarBodyEnough(UUID id) {
        if (carBodyService.getCarBodyById(id).getAmount() > 0) {
            return true;
        } else {
            throw new ProductNotFoundException("Not enough car bodies");
        }
    }
}
