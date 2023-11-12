package christmas.controller;

import christmas.model.MenuItem;

import java.util.Map;

public class MenuOrders {
    private final Map<MenuItem, Integer> orders;

    public MenuOrders(Map<MenuItem, Integer> orders) {
        this.orders = orders;
    }
}
