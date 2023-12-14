package com.example.autoservice.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarWheelDto {

    @Schema(description = "Car wheel size", example = "R15")
    @Pattern(regexp = ("^R\\d+$"), message = "Non valid car wheel size")
    @NotNull
    private String size;

    @Schema(description = "Car wheel condition", example = "New")
    @Pattern(regexp = ("^(?i)(New|Used)$"), message = "Non valid car wheel condition")
    @NotNull
    private String condition;

    @Schema(description = "Car wheel amount", example = "27")
    @NotNull
    private Integer amount;

    @Schema(description = "Car wheel price", example = "22650")
    @NotNull
    private Double price;

}
