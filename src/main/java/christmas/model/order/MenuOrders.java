package christmas.model.order;

import christmas.model.menu.MenuItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class MenuOrders {
    private final Map<MenuItem, Integer> orders;

    public MenuOrders(Map<MenuItem, Integer> orders) {
        OrderValidate.checkOrders(orders);
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

    public boolean isOrderHaveMenu(String menu) {
        return orders.entrySet().stream()
                .anyMatch(entry -> entry.getKey().getCategory().equals(menu));
    }

    public Integer getValueSumByMenu(String menu) {
        return orders.entrySet().stream()
                .filter(entry -> entry.getKey().getCategory().equals(menu))
                .mapToInt(Map.Entry::getValue)
                .sum();
    }
}
