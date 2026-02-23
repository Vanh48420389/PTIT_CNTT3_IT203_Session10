abstract class Vehicle {
    protected String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public abstract void move();
}

class Car extends Vehicle {

    public Car(String brand) {
        super(brand);
    }

    @Override
    public void move() {
        System.out.println(brand + "  Di chuyển bằng động cơ");
    }
}

class Bicycle extends Vehicle {

    public Bicycle(String brand) {
        super(brand);
    }

    @Override
    public void move() {
        System.out.println(brand + "  Di chuyển bằng sức người");
    }
}

public class Bai2 {
    public static void main(String[] args) {
        Vehicle myCar = new Car("Toyota");
        Vehicle myBicycle = new Bicycle("Giant");

        myCar.move();
        myBicycle.move();
    }
}