package com.example.autoservice.infrastructure.api.controller;

import com.example.autoservice.appservice.CarWheelService;
import com.example.autoservice.domain.dto.CarWheelDto;
import com.example.autoservice.domain.model.CarWheel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Car wheel controller")
@RestController
@RequestMapping("/catalog/tyres")
public class CarWheelController {

    private final CarWheelService carWheelService;

    @Autowired
    public CarWheelController(CarWheelService carWheelService) {
        this.carWheelService = carWheelService;
    }

    @Operation(summary = "Get all car tyres")
    @GetMapping("/all")
    public ResponseEntity<List<CarWheel>> getAllCarWheels() {
        return new ResponseEntity<>(carWheelService.getCarWheels(), HttpStatus.OK);
    }

    @Operation(summary = "Get car tire by id")
    @GetMapping("/{id}")
    public ResponseEntity<CarWheel> getCarWheelById(@PathVariable UUID id) {
        return new ResponseEntity<>(carWheelService.getCarWheelById(id), HttpStatus.OK);
    }

    @Operation(summary = "Save car wheel")
    @PostMapping(consumes = "application/json")
    public ResponseEntity<CarWheel> save(@RequestBody @Valid CarWheelDto carWheelDto) {
        CarWheel carWheel = carWheelService.save(CarWheel.builder()
                .size(carWheelDto.getSize())
                .condition(carWheelDto.getCondition())
                .amount(carWheelDto.getAmount())
                .price(carWheelDto.getPrice())
                .build());
        return new ResponseEntity<>(carWheel, HttpStatus.CREATED);
    }

    @Operation(summary = "Delete car tire by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        carWheelService.removeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
