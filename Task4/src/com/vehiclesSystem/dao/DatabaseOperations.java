package com.vehiclesSystem.dao;

import com.vehiclesSystem.models.*;
import com.vehiclesSystem.models.Type;
import com.vehiclesSystem.models.Vehicle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;
@Scope("singleton")
@Component
public class DatabaseOperations {

    @Value("${db.url}")
    private String url;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    private Connection connection;

    @PostConstruct
    public void connectToDatabase() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void disconnectFromDatabase() {
        try {
            connection.close();
            System.out.println("connection has been closed......");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(Vehicle vehicle) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(
                    "INSERT INTO vehicle VALUES (" +
                            vehicle.getId() + ",'" +
                            vehicle.getModel()+ "','" +
                            vehicle.getType() + "')"
            );
            System.out.println(String.format("vehicle %s %s Saved Sucssesfuly" ,vehicle.getModel(), vehicle.getType()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(
                    "DELETE FROM vehicle WHERE id = " + id
            );
            System.out.println("Vehicle with id " + id + " deleted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Vehicle vehicle) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(
                    "UPDATE vehicle SET model = '" +
                            vehicle.getModel() + "', type = '" +
                            vehicle.getType().name() +
                            "' WHERE id = " + vehicle.getId()
            );
            System.out.println(String.format("Vehicle %s %s updated successfully " , vehicle.getModel(),vehicle.getType()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchById(int id) {
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(
                    "SELECT * FROM vehicle WHERE id = " + id
            );

            if (result.next()) {
                String model = result.getString("model"); // gebna el model
                Type type = Type.valueOf(result.getString("type")); // eltayeb fe taype

                System.out.println(String.format(
                        "////////////////////////////////////\n" +
                        "vehicle id : %d \nvehicle model : %s \nvehicle type : %s" +
                        "\n//////////////////////////////////// ",
                        id,model,type));
            }
            else {
                System.out.println(String.format("No vehicle with id %d" , id));
            }
        }
         catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void getAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(
                    "SELECT * FROM vehicle"
            );

            System.out.println("///////////////////////////");
            while (result.next()) {
                int id = result.getInt("id");
                String model = result.getString("model");
                String type = result.getString("type");

                System.out.println(String.format(
                        "vehicle id : %d\nvehicle model : %s\nvehicle type : %s\n///////////////////////////",
                        id, model, type
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
