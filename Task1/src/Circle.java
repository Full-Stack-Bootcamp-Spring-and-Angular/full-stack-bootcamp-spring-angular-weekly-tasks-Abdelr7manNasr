public class Circle implements Shape {
    private double r;
    public Circle(double r) {
        this.r = r;
    }
    @Override
    public double getArea() {
        return 3.14 * r * r;
    }
}
