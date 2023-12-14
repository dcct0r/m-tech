package com.example.autoservice.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarBodyDto {

    @Schema(description = "Car body type", example = "Sedan")
    @Pattern(regexp = ("^[a-zA-z]+$"), message = "Non valid car type")
    @NotNull
    private String type;

    @Schema(description = "Car body condition", example = "Used")
    @Pattern(regexp = ("^(?i)(New|Used)$"), message = "Non valid car wheel condition")
    @NotNull
    private String condition;

    @Schema(description = "Car body amount", example = "27")
    @NotNull
    private Integer amount;

    @Schema(description = "Car body price", example = "22650")
    @NotNull
    private Double price;

}
