package com.example.autoservice.domain.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "car_wheels", schema = "app")
public class CarWheel implements Serializable {

    @Schema(description = "Car wheel ID", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
    @Id
    @Column(name = "car_wheels_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Schema(description = "Car wheel size", example = "R16")
    @Column(name = "size")
    @NotNull
    private String size;

    @Schema(description = "Car wheel condition", example = "Used")
    @Column(name = "condition")
    @NotNull
    private String condition;

    @Schema(description = "Car wheel amount", example = "143")
    @Column(name = "amount")
    @NotNull
    private Integer amount;

    @Schema(description = "Car wheel price", example = "22600")
    @Column(name = "price")
    @NotNull
    private Double price;

}
