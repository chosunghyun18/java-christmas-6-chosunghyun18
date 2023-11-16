package christmas.back.domain.event.discount;

import christmas.back.domain.event.config.BaseEvent;
import christmas.back.domain.event.config.EventType;
import christmas.back.domain.order.MenuOrders;
import christmas.back.domain.user.model.Client;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeekEvent extends BaseEvent {
    public static final Integer WEEK_EVENT_BENEFIT_VALUE = 2023;
    private final List<Integer> days;

    public WeekEvent(List<Integer> days) {
        this.days = days;
    }
    @Override
    public Boolean canGetEvent(Client client, MenuOrders menuOrders) {
        return days.contains(client.getVisitDay()) & menuOrders.isOrderHaveMenu("디저트") ;
    }
    @Override
    public Map<EventType, Integer> getEventBenefit(Client client,MenuOrders menuOrders) {
        int amount = WEEK_EVENT_BENEFIT_VALUE* menuOrders.getValueSumByMenu("디저트");
        Map<EventType, Integer> benefitMap = new HashMap<>();
        benefitMap.put(EventType.WeekEvent, amount);
        return benefitMap;
    }
    @Override
    public void updateClientBenefit(Client client,MenuOrders menuOrders) {
        client.joinEvent();
        int benefit = WEEK_EVENT_BENEFIT_VALUE* menuOrders.getValueSumByMenu("디저트");
        client.addBenefitToTotalDiscountAndEventBenefit(benefit);
    }
}
