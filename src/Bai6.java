import java.util.Arrays;
import java.util.Comparator;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Sản phẩm: %-15s | Giá: %,.0f VNĐ", name, price);
    }
}

public class Bai6 {
    public static void main(String[] args) {

        Product[] products = new Product[] {
                new Product("Laptop Dell", 25000000),
                new Product("Bàn phím cơ", 1500000),
                new Product("Chuột Logitech", 500000),
                new Product("Màn hình LG", 4500000)
        };

        System.out.println("--- DANH SÁCH BAN ĐẦU ---");
        printArray(products);


        Arrays.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.getPrice(), p2.getPrice());
            }
        });

        System.out.println("\n--- SẮP XẾP THEO GIÁ (TĂNG DẦN - Anonymous Class) ---");
        printArray(products);


        Arrays.sort(products, (p1, p2) -> p1.getName().compareTo(p2.getName()));

        System.out.println("\n--- SẮP XẾP THEO TÊN (A-Z - Lambda Expression) ---");
        printArray(products);
    }

    private static void printArray(Product[] arr) {
        for (Product p : arr) {
            System.out.println(p);
        }
    }
}