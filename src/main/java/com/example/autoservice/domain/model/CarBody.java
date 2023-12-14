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
@Table(name = "car_bodies", schema = "app")
public class CarBody implements Serializable {

    @Schema(description = "Car body ID", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
    @Id
    @Column(name = "car_bodies_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Schema(description = "Car body type", example = "Sedan")
    @Column(name = "type")
    @NotNull
    private String type;

    @Schema(description = "Car body condition", example = "Used")
    @Column(name = "condition")
    @NotNull
    private String condition;

    @Schema(description = "Car body amount", example = "143")
    @Column(name = "amount")
    @NotNull
    private Integer amount;

    @Schema(description = "Car body price", example = "22600")
    @Column(name = "price")
    @NotNull
    private Double price;

}


