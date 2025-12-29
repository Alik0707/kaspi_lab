package service;

import entity.Order;
import java.util.*;


public class Cart {
    private final List<Order> orders = new ArrayList<>();



    // Добавление заказа
    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> findOrdersAbovePrice(double price) {
        // сортировка по убыванию для удоного поиска
        orders.sort(Comparator.comparingDouble(Order::getPrice).reversed());
        List<Order> res = new ArrayList<>();

        for (Order order : orders) {
            if (order.getPrice() < price)break;
            res.add(order);

        }
        return res;

    }
    //группировка по категориям с помощью hash map
    public Map<String,Long> groupByCategory() {
        Map<String,Long> map = new HashMap<>();
        for (Order order : orders) {
            String category = order.getCategory();
            if (map.containsKey(category)) {
                map.put(category, map.get(category) + 1);
            }
            else {
                map.put(category, 1L);
            }

        }
        return map;
    }


}
