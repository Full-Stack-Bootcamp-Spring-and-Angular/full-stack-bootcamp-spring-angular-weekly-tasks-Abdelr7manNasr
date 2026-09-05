package com.vehicles;

public class Car implements vehicle{
    private DatabaseOperation databaseOperation;
    public Car(DatabaseOperation databaseOperation) {
        this.databaseOperation = databaseOperation;
    }

    @Override
    public void savevehicle() {
        databaseOperation.saveVehicle("Car");
    }
}
