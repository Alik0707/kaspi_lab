package entity;

public class Order {
    private final String name;
    private final String category;
    private final double price;

    public Order(String name, String Category, double price) {
        this.name = name;
        this.category = Category;
        this.price = price;
    }

    public double getPrice() {
        return price;

    }

    public String getName() {
        return name;

    }

    public String getCategory() {
        return category;

    }

    @Override
    public String toString() {
        return "Order{" +
                "Name='" + name + '\'' +
                ", Category='" + category + '\'' +
                ", Price=" + price +
                '}';
    }
}
