package com.example.autoservice;

import com.example.autoservice.appservice.CarBodyService;
import com.example.autoservice.appservice.CarService;
import com.example.autoservice.appservice.CarWheelService;
import com.example.autoservice.domain.model.Car;
import com.example.autoservice.infrastructure.api.controller.CarController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class CarControllerTest {

    @Mock
    CarService carService;

    @Mock
    CarBodyService carBodyService;

    @Mock
    CarWheelService carWheelService;

    @InjectMocks
    CarController carController;

    @Test
    @DisplayName("GET catalog/cars/all request returns HTTP code 200 OK")
    void handleGetAllCars_ReturnsValidResponseEntity() {
        //given
        var cars = List.of(new Car(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), 4, new Date()));
        doReturn(cars).when(this.carService).getCars();
        //when
        var respEntity = this.carController.getCars();
        //then
        assertNotNull(respEntity);
        assertEquals(HttpStatus.OK, respEntity.getStatusCode());
        assertEquals(cars, respEntity.getBody());
    }

    @Test
    @DisplayName("GET catalog/cars/{id} request returns HTTP code 200 OK")
    void handleGetCarById_ReturnsValidResponseEntity() {
        //given
        var temp = UUID.randomUUID();
        var cars = new Car(temp, temp, temp, 4, new Date());
        doReturn(cars).when(this.carService).getCarById(temp);
        //when
        var respEntity = this.carController.getCarById(temp);
        //then
        assertNotNull(respEntity);
        assertEquals(HttpStatus.OK, respEntity.getStatusCode());
        assertEquals(cars, respEntity.getBody());
    }
}
