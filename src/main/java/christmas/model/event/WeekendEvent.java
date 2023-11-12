package christmas.model.event;

import christmas.model.order.MenuOrders;
import java.util.List;

public class WeekendEvent {
    public WeekendEvent(List<Integer> days) {
        this.days = days;
    }

    private final List<Integer> days;

    public Boolean canGetEvent(Integer day, MenuOrders menuOrders) {
        return days.contains(day) & menuOrders.isOrderHaveMenu("메인");
    }

    public Integer getEventBenefit(MenuOrders menuOrders) {
        return 2023 * menuOrders.getValueSumByMenu("메인");
    }
}
