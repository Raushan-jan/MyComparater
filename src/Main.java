import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void run() {
        Product[] products = {
                new Product("AMD Ryzen 7 3700X", "Top processor", 178000),
                new Product("Intel Core I7 4700", "Old processor", 85000),
                new Product("Asus Xonar STX II", "Good audio card", 120000)
        };

        // Solution via insertion sort
        mySort(products);
        System.out.println(Arrays.toString(products));

        // Solution via `Comparator` and `Comparable`
        Arrays.sort(products, Comparator.naturalOrder());
        System.out.println(Arrays.toString(products));
    }

    private static void mySort(Product[] products) {
        for (int z = 1; z < products.length; z++) {
            for (int f = z; f > 0; f--) {
                if (products[f].getPrice() < products[f - 1].getPrice()) {
                    Product temp = products[f - 1];
                    products[f - 1] = products[f];
                    products[f] = temp;
                }
            }
        }
    }
}
class Product implements Comparable<Product> {
    private final String name;
    private final String description;
    private final int price;

    public Product(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public int compareTo(Product o) {
        return price - o.price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
