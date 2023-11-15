package christmas.back.domain.event.discount;

import christmas.back.domain.event.config.BaseEvent;
import christmas.back.domain.event.config.EventType;
import christmas.back.domain.order.MenuOrders;
import christmas.back.domain.user.model.Client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeekendEvent extends BaseEvent {
    private static final Integer WEEKEND_EVENT_BENEFIT_VALUE = 2023;

    public WeekendEvent(List<Integer> days) {
        this.days = days;
    }

    private final List<Integer> days;
    @Override
    public Boolean canGetEvent(Client client, MenuOrders menuOrders) {
        return days.contains(client.getVisitDay()) & menuOrders.isOrderHaveMenu("메인");
    }
    @Override
    public Map<EventType,Integer> getEventBenefit(Client client,MenuOrders menuOrders) {
        int amount = WEEKEND_EVENT_BENEFIT_VALUE * menuOrders.getValueSumByMenu("메인");
        Map<EventType, Integer> benefitMap = new HashMap<>();
        benefitMap.put(EventType.WeekendEvent, amount);
        return benefitMap;
    }
    @Override
    public void updateClientBenefit(Client client,MenuOrders menuOrders) {
        client.joinEvent();
        int amount = WEEKEND_EVENT_BENEFIT_VALUE * menuOrders.getValueSumByMenu("메인");
        client.addBenefitToTotalDiscountAndEventBenefit(amount);
    }
}
