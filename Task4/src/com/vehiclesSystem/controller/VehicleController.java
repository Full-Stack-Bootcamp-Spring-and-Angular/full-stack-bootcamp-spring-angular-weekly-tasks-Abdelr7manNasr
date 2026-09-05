package com.vehiclesSystem.controller;

import com.vehiclesSystem.models.Vehicle;

public interface VehicleController {
    void saveVehicle(Vehicle vehicle);

    void deleteVehicle(int id);

    public void updateVehicle(Vehicle vehicle);

    public void searchVehicleById(int id);

}