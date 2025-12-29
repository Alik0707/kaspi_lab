package app;


import entity.Order;
import service.Cart;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {

        // Создаём корзину
        Cart cart = new Cart();

        // Добавляем тестовые заказы
        cart.addOrder(new Order("Phone", "Electronics", 500));
        cart.addOrder(new Order("Laptop", "Electronics", 1200));
        cart.addOrder(new Order("Headphones", "Electronics", 150));
        cart.addOrder(new Order("Book", "Books", 20));
        cart.addOrder(new Order("Notebook", "Books", 5));
        cart.addOrder(new Order("Pen", "Stationery", 2));
        cart.addOrder(new Order("Desk", "Furniture", 200));
        cart.addOrder(new Order("Chair", "Furniture", 120));

        // Тест метода поиска по цене
        double minPrice = 100;
        List<Order> expensiveOrders = cart.findOrdersAbovePrice(minPrice);

        System.out.println("Заказы с ценой выше " + minPrice + ":");
        for (Order o : expensiveOrders) {
            System.out.println(o);
        }

        // Тест метода группировки по категориям
        Map<String, Long> grouped = cart.groupByCategory();

        System.out.println("\nГруппировка заказов по категориям:");
        for (String category : grouped.keySet()) {
            System.out.println(category + ": " + grouped.get(category));
        }
    }


}
