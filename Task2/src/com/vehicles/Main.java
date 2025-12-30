package com.vehicles;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Car car = context.getBean("car" , Car.class);
        car.savevehicle();

        Plane plane = context.getBean("plane" , Plane.class);
        plane.savevehicle();
    }
}
