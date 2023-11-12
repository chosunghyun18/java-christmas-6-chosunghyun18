package christmas.controller;

import christmas.model.MenuItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MenuOrders {
    private final Map<MenuItem, Integer> orders;

    public MenuOrders(Map<MenuItem, Integer> orders) {
        this.orders = orders;
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
        long countAmount = orders.entrySet().stream()
                .filter(entry -> entry.getKey().getCategory().equals("디저트"))
                .count();

        return (int) (2023 * countAmount);
    }

    public Integer getWeekendDiscountAmount() {
        long countAmount = orders.entrySet().stream()
                .filter(entry -> entry.getKey().getCategory().equals("메인"))
                .count();

        return (int) (2023 * countAmount);
    }

}
