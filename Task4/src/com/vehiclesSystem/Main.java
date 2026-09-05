package com.vehiclesSystem;

import com.vehiclesSystem.config.Config;
import com.vehiclesSystem.controller.BikeController;
import com.vehiclesSystem.controller.CarController;
import com.vehiclesSystem.controller.PlaneController;
import com.vehiclesSystem.controller.VehicleController;
import com.vehiclesSystem.dao.DatabaseOperations;
import com.vehiclesSystem.models.Bike;
import com.vehiclesSystem.models.Car;
import com.vehiclesSystem.models.Plane;
import com.vehiclesSystem.models.Vehicle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        DatabaseOperations db =
                context.getBean(DatabaseOperations.class);

        CarController carController =
                context.getBean(CarController.class);

        PlaneController planeController =
                context.getBean(PlaneController.class);

        BikeController bikeController =
                context.getBean(BikeController.class);

        Car car = context.getBean(Car.class);
        car.setId(1);
        car.setModel("BMW");
        carController.saveVehicle(car);

        Plane plane = context.getBean(Plane.class);
        plane.setId(2);
        plane.setModel("AirBus");
        planeController.saveVehicle(plane);

        Bike bike = context.getBean(Bike.class);
        bike.setId(3);
        bike.setModel("Hogan");
        bikeController.saveVehicle(bike);

        db.getAll();

        planeController.searchVehicleById(2);

        car.setModel("BMW M5");
        carController.updateVehicle(car);

        bikeController.deleteVehicle(3);

        db.getAll();

        context.close();
    }
}
