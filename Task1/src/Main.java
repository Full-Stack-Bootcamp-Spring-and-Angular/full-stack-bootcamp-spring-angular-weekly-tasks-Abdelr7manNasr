import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double length = input.nextDouble();
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Shape circle = (Circle) context.getBean("circle", length);
        Shape square = (Square) context.getBean("square", length);

        System.out.println(String.format("The area of the circle = %.2f", circle.getArea()));
        System.out.println(String.format("The area of the square = %.2f", square.getArea()));

    }
}