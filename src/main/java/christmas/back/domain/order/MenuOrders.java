package christmas.back.domain.order;

import christmas.back.domain.menu.MenuItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MenuOrders {
    private final Long id;
    private final Map<MenuItem, Integer> orders;

    private MenuOrders(Long id, Map<MenuItem, Integer> orders) {
        OrderValidate.checkOrders(orders);
        this.id = id;
        this.orders = orders;
    }

    public MenuOrders(Map<MenuItem, Integer> orders) {
        this(null, new TreeMap<>(orders));
    }

    public MenuOrders(Long id, MenuOrders menuOrders) {
        this(id, menuOrders.orders);
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

    public Boolean canNotGetEvent() {
        int totalPrice = orders.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getItemPrice() * entry.getValue())
                .sum();
        return totalPrice < 10000;
    }

    public Long getId() {
        return id;
    }
}
