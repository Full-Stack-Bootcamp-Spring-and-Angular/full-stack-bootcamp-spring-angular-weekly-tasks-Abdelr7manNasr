package com.injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ApplicationContext context=
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Circle cricle =(Circle) context.getBean("circle");
        cricle.Draw();

        //Draw2d draw2d = new Draw2d();
       Square square = (Square) context.getBean("square");
       //square.setDraw2d(draw2d);
       square.Draw();
    }
}