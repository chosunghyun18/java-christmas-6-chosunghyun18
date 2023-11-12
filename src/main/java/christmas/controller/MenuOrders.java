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
}
