package com.example.autoservice.infrastructure.api.controller;

import com.example.autoservice.appservice.CarBodyService;
import com.example.autoservice.domain.dto.CarBodyDto;
import com.example.autoservice.domain.model.CarBody;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Car body controller")
@RestController
@RequestMapping("/catalog/bodies")
public class CarBodyController {

    private final CarBodyService carBodyService;

    public CarBodyController(CarBodyService carBodyService) {
        this.carBodyService = carBodyService;
    }

    @Operation(summary = "Get all car bodies")
    @GetMapping("/all")
    public ResponseEntity<List<CarBody>> getAllCarBodies() {
        return new ResponseEntity<>(carBodyService.getCarBodies(), HttpStatus.OK);
    }

    @Operation(summary = "Get car body by id")
    @GetMapping("/{id}")
    public ResponseEntity<CarBody> getCarBodyById(@PathVariable UUID id) {
        return new ResponseEntity<>(carBodyService.getCarBodyById(id), HttpStatus.OK);
    }

    @Operation(summary = "Save car body")
    @PostMapping(consumes = "application/json")
    public ResponseEntity<CarBody> save(@RequestBody @Valid CarBodyDto carBodyDto) {
        CarBody carBody = carBodyService.save(CarBody.builder()
                .type(carBodyDto.getType())
                .condition(carBodyDto.getCondition())
                .amount(carBodyDto.getAmount())
                .price(carBodyDto.getPrice())
                .build());
        return new ResponseEntity<>(carBody, HttpStatus.CREATED);
    }

    @Operation(summary = "Delete car body by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        carBodyService.removeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
