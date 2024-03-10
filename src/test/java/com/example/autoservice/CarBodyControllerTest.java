package com.example.autoservice;

import com.example.autoservice.appservice.CarBodyService;
import com.example.autoservice.domain.model.CarBody;
import com.example.autoservice.infrastructure.api.controller.CarBodyController;
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
public class CarBodyControllerTest {

    @Mock
    CarBodyService carBodyService;

    @InjectMocks
    CarBodyController carBodyController;

    @Test
    @DisplayName("GET catalog/bodies/all request returns HTTP code 200 OK")
    void handleGetAllCarBodies_ReturnsValidResponseEntity() {
        //given
        var body = List.of(new CarBody(UUID.randomUUID(), "sedan", "new", 5, 1000.2));
        doReturn(body).when(this.carBodyService).getCarBodies();
        //when
        var respEntity = this.carBodyController.getAllCarBodies();
        //then
        assertNotNull(respEntity);
        assertEquals(HttpStatus.OK, respEntity.getStatusCode());
        assertEquals(body, respEntity.getBody());
    }

    @Test
    @DisplayName("GET catalog/bodies/{id} request returns HTTP code 200 OK")
    void handleGetCarBodyById_ReturnsValidResponseEntity() {
        //given
        var tUUID = UUID.randomUUID();
        var body = new CarBody(tUUID, "sedan", "new", 5, 1000.2);
        doReturn(body).when(this.carBodyService).getCarBodyById(tUUID);
        //when
        var respEntity = this.carBodyController.getCarBodyById(tUUID);
        //then
        assertNotNull(respEntity);
        assertEquals(HttpStatus.OK, respEntity.getStatusCode());
        assertEquals(body, respEntity.getBody());
    }
}
