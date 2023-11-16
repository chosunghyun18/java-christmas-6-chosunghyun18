package christmas.back.domain.order;

import christmas.back.domain.menu.MenuItem;
import java.util.Map;

public class OrderValidate {

    public static void checkOrders(Map<MenuItem, Integer> orders) {
        chekcTotalAmount(orders);
        checkOnlyDrink(orders);
    }
    private static void chekcTotalAmount(Map<MenuItem, Integer> orders) {
        Integer totalValue = orders.values().stream()
                .mapToInt(i -> i)
                .sum();
        if(totalValue >20) throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
    private static void checkOnlyDrink(Map<MenuItem, Integer> orders) {
        int onlyedesert = orders.entrySet().stream()
                .filter(entry -> entry.getKey().getCategory().equals("디저트")).toList().size();
        if (onlyedesert == orders.size())
            throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}
