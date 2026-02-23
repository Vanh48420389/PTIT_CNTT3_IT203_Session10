abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }
}

interface Swimmable {
    void swim();
}

interface Flyable {
    void fly();
}

class Duck extends Animal implements Swimmable, Flyable {

    public Duck(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println(name + " đang bơi lạch bạch trên mặt hồ.");
    }

    @Override
    public void fly() {
        System.out.println(name + " đang vỗ cánh bay lên trời.");
    }
}

class Fish extends Animal implements Swimmable {

    public Fish(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println(name + " đang tung tăng bơi dưới nước.");
    }
}

public class Bai3 {
    public static void main(String[] args) {
        Duck donald = new Duck("Vịt Donald");
        Fish nemo = new Fish("Cá Nemo");

        donald.swim();
        donald.fly();

        nemo.swim();


    }
}