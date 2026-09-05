package main.dao;

import main.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

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
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("connection has been established......");

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
    public void saveUser(User u) {

        String sql = "INSERT INTO users(first_name, last_name, email, date_of_birth, city) VALUES (?,?,?,?,?)";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, u.getFirstName());
            ps.setString(2, u.getLastName());
            ps.setString(3, u.getEmail());
            ps.setDate(4, u.getDateOfBirth());
            ps.setString(5, u.getCity());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    }
