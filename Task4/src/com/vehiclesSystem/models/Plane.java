package com.vehiclesSystem.models;

import lombok.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Getter
@Setter

@Scope("prototype")
@Component

public class Plane implements Vehicle {
    private int id;
    private String model;
    private final Type type=Type.Plane;
}
