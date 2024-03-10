package com.example.autoservice;

import com.example.autoservice.appservice.CarWheelService;
import com.example.autoservice.domain.model.CarWheel;
import com.example.autoservice.infrastructure.api.controller.CarWheelController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class CarWheelControllerTest {

    @Mock
    CarWheelService carWheelService;

    @InjectMocks
    CarWheelController carWheelController;

    @Test
    void handleGetAllWheels_ReturnsValidResponseEntity() {
        //given
        var wheel = List.of(new CarWheel(UUID.randomUUID(), "15R", "new", 5, 2200.2));
        doReturn(wheel).when(this.carWheelService).getCarWheels();
        //when
        var respEntity = this.carWheelController.getAllCarWheels();
        //then
        assertNotNull(respEntity);
        assertEquals(HttpStatus.OK, respEntity.getStatusCode());
        assertEquals(wheel, respEntity.getBody());
    }

    @Test
    @DisplayName("GET catalog/tyres/all request returns HTTP code 200 OK")
    void handleGetAllWheels_ReturnsInvalidResponseEntity() {
        //given
        var wheel = List.of(new CarWheel(UUID.randomUUID(), "15R", "new", 0, 2200.2));
        doReturn(wheel).when(this.carWheelService).getCarWheels();
        //when
        var respEntity = this.carWheelController.getAllCarWheels();
        //then
        assertNotNull(respEntity);
        assertEquals(HttpStatus.OK, respEntity.getStatusCode());
        assertEquals(wheel, respEntity.getBody());
    }

    @Test
    @DisplayName("GET catalog/tyres/{id} request returns HTTP code 200 OK")
    void handleGetWheelsById_ReturnsValidResponseEntity() {
        //given
        UUID temp = UUID.randomUUID();
        var wheel = new CarWheel(temp, "15R", "new", 5, 2200.2);
        doReturn(wheel).when(this.carWheelService).getCarWheelById(temp);
        //when
        var respEntity = this.carWheelController.getCarWheelById(temp);
        //then
        assertNotNull(respEntity);
        assertEquals(HttpStatus.OK, respEntity.getStatusCode());
        assertEquals(wheel, respEntity.getBody());
    }
}
