package com.example.autoservice.domain.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "car", schema = "app")
public class Car {

    @Schema(description = "Car ID", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "car_id")
    private UUID id;

    @Schema(description = "Car body ID", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
    @Column(name = "body_id")
    @NotNull
    private UUID carBodyId;

    @Schema(description = "Car wheel ID", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
    @Column(name = "wheel_id")
    @NotNull
    private UUID carWheelId;

    @Schema(description = "Car wheel amount", example = "143")
    @Column(name = "car_wheels_amount")
    @NotNull
    private Integer carWheelsAmount;

    @Schema(description = "Date of order", example = "2023-12-13T18:35:31.540Z")
    @Column(name = "order_date")
    @CreationTimestamp
    private Date orderDate;

}
