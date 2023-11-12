package christmas.model.event.discount;

import christmas.model.order.MenuOrders;
import java.util.List;

public class WeekEvent {
    private final List<Integer> days;

    public WeekEvent(List<Integer> days) {
        this.days = days;
    }

    public Boolean canGetEvent(Integer day,MenuOrders menuOrders) {
        return days.contains(day) & menuOrders.isOrderHaveMenu("디저트") ;
    }

    public Integer getEventBenefit(MenuOrders menuOrders) {
        return  2023* menuOrders.getValueSumByMenu("디저트");
    }
}
