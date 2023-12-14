package com.example.autoservice.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CarDto {

    @Schema(description = "Car body ID", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
    @NotNull
    private UUID carBodyId;

    @Schema(description = "Car wheel ID", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
    @NotNull
    private UUID carWheelId;

    @Schema(description = "Car wheel amount", example = "143")
    @NotNull
    private Integer carWheelsAmount;
    
}
