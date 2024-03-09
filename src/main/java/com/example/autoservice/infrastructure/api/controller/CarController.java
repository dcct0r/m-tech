package com.example.autoservice.infrastructure.api.controller;

import com.example.autoservice.infrastructure.service.availability.AssemblyChecker;
import com.example.autoservice.appservice.CarBodyService;
import com.example.autoservice.appservice.CarService;
import com.example.autoservice.domain.dto.CarDto;
import com.example.autoservice.domain.model.Car;
import com.example.autoservice.appservice.CarWheelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Car controller")
@RestController
@RequestMapping("/catalog/cars")
public class CarController {

    private final CarService carService;
    private final CarBodyService carBodyService;
    private final CarWheelService carWheelService;

    @Autowired
    public CarController(CarService carService, CarBodyService carBodyService, CarWheelService carWheelService) {
        this.carService = carService;
        this.carBodyService = carBodyService;
        this.carWheelService = carWheelService;
    }

    @Operation(summary = "Get all stocks")
    @GetMapping("/all")
    public ResponseEntity<List<Car>> getCars() {
        return new ResponseEntity<>(carService.getCars(), HttpStatus.OK);
    }

    @Operation(summary = "Get stocks by id")
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable UUID id) {
        return new ResponseEntity<>(carService.getCarById(id), HttpStatus.OK);
    }

    @Operation(summary = "Save stocks")
    @PostMapping(consumes = "application/json")
    public ResponseEntity<Car> save(@RequestBody CarDto carDto) {
        AssemblyChecker assemblyChecker = new AssemblyChecker(carWheelService, carBodyService);
        if (assemblyChecker.isCreationPossible(carDto)) {
            Car car = carService.save(Car.builder()
                    .carBodyId(carDto.getCarBodyId())
                    .carWheelId(carDto.getCarWheelId())
                    .carWheelsAmount(carDto.getCarWheelsAmount())
                    .build());
            return new ResponseEntity<>(car, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Operation(summary = "Delete stock by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        carService.removeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
