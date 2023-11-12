package christmas.model;

import christmas.model.MenuItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class MenuOrders {
    private final Map<MenuItem, Integer> orders;

    public MenuOrders(Map<MenuItem, Integer> orders) {
        this.orders = new TreeMap<>(orders);
    }

    public List<Map<String, Integer>> getOrderForMessage() {
        return orders.entrySet().stream()
                .map(entry -> {
                    Map<String, Integer> orderMap = new HashMap<>();
                    orderMap.put(entry.getKey().getItemName(), entry.getValue());
                    return orderMap;
                })
                .toList();
    }

    public Integer getTotalAmountBeforeDiscount() {
        return orders.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getItemPrice() * entry.getValue())
                .sum();
    }

    public boolean canGetWeekDiscount() {
        return orders.entrySet().stream()
                .anyMatch(entry -> entry.getKey().getCategory().equals("디저트"));
    }

    public boolean canGetWeekendDiscount() {
        return orders.entrySet().stream()
                .anyMatch(entry -> entry.getKey().getCategory().equals("메인"));
    }

    public Integer getWeekDiscountAmount() {
        return 2023 * orders.entrySet().stream()
                .filter(entry -> entry.getKey().getCategory().equals("디저트"))
                .mapToInt(Map.Entry::getValue)
                .sum();
    }

    public Integer getWeekendDiscountAmount() {
        return 2023 * orders.entrySet().stream()
                .filter(entry -> entry.getKey().getCategory().equals("메인"))
                .mapToInt(Map.Entry::getValue)
                .sum();
    }

}
