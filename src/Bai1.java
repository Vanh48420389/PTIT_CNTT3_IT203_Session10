interface Shape {
    double getArea();
    double getPerimeter();
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}

public class Bai1 {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0);

        Shape rectangle = new Rectangle(4.0, 6.0);

        System.out.println("Hình tròn");
        System.out.printf("Diện tích: %.2f\n", circle.getArea());
        System.out.printf("Chu vi: %.2f\n", circle.getPerimeter());

        System.out.println("\nHình chữ nhật");
        System.out.printf("Diện tích: %.2f\n", rectangle.getArea());
        System.out.printf("Chu vi: %.2f\n", rectangle.getPerimeter());
    }
}