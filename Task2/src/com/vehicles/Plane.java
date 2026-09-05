package com.vehicles;

public class Plane implements vehicle{
    private DatabaseOperation databaseOperation;
    @Override
    public void savevehicle() {
        databaseOperation.saveVehicle("Plane");
    }

    public void setDatabaseOperation(DatabaseOperation databaseOperation) {
        this.databaseOperation = databaseOperation;
    }
}
