package com.example.autoservice.infrastructure.service.availability;

import com.example.autoservice.domain.dto.CarDto;
import com.example.autoservice.appservice.CarBodyService;
import com.example.autoservice.appservice.CarWheelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssemblyChecker {
    private final CarWheelService carWheelService;
    private final CarBodyService carBodyService;

    @Autowired
    public AssemblyChecker(CarWheelService carWheelService, CarBodyService carBodyService) {
        this.carWheelService = carWheelService;
        this.carBodyService = carBodyService;
    }

    public boolean isCreationPossible(CarDto carDto) {
        CarBodyInventoryItem carBodyItem = new CarBodyInventoryItem(carBodyService);
        CarWheelInventoryItem carWheelItem = new CarWheelInventoryItem(carWheelService);

        return carBodyItem.isCarBodyExist(carDto.getCarBodyId()) &&
                carBodyItem.isCarBodyEnough(carDto.getCarBodyId()) &&
                carWheelItem.isCarWheelExist(carDto.getCarWheelId()) &&
                carWheelItem.isCarWheelEnough(carDto.getCarWheelId());
    }
}
