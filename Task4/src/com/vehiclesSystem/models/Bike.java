package com.vehiclesSystem.models;

import lombok.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Getter
@Setter

@Component
@Scope("prototype")

public class Bike implements Vehicle {
    private int id;
    private String model;
    private final Type type=Type.Bike;
}
