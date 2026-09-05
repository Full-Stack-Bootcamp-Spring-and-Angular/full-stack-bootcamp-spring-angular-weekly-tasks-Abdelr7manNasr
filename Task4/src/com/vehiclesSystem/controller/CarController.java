package com.vehiclesSystem.controller;

import com.vehiclesSystem.dao.DatabaseOperations;
import com.vehiclesSystem.models.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class CarController implements VehicleController {

    private DatabaseOperations databaseOperations;

    public CarController(DatabaseOperations databaseOperations) {
        this.databaseOperations = databaseOperations;
    }

    @Override
    public void saveVehicle(Vehicle vehicle) {
        databaseOperations.save(vehicle);
    }

    @Override
    public void deleteVehicle(int id) {
        databaseOperations.delete(id);
    }

    @Override
    public void updateVehicle(Vehicle vehicle) {
        databaseOperations.update(vehicle);
    }

    @Override
    public void searchVehicleById(int id) {
        databaseOperations.searchById(id);
    }
}
