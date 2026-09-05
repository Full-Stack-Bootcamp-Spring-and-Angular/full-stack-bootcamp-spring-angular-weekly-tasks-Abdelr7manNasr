package com.vehiclesSystem.models;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Scope("prototype")
@Component
public class Car implements Vehicle {
    private int id;
    private String model;
    private final Type type=Type.Car;

  }
