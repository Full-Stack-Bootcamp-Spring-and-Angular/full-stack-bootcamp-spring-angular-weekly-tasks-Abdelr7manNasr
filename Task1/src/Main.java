import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double x = input.nextDouble();
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Shape c = (Circle) context.getBean("circle", x);
        Shape s = (Square) context.getBean("square", x);

        System.out.println("the area of the circle = " + c.getArea());
        System.out.println("the area of the Square = " + s.getArea());
    }
}