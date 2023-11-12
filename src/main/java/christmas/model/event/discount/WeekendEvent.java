package christmas.model.event.discount;

import christmas.model.User.Client;
import christmas.model.event.BaseEvent;

import christmas.model.event.EventType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeekendEvent extends BaseEvent {
    public WeekendEvent(List<Integer> days) {
        this.days = days;
    }

    private final List<Integer> days;
    @Override
    public Boolean canGetEvent(Client client) {
        return days.contains(client.getVisitDay()) & client.getMenuOrders().isOrderHaveMenu("메인");
    }
    @Override
    public Map<EventType,Integer> getEventBenefit(Client client) {
        int amount = 2023 * client.getMenuOrders().getValueSumByMenu("메인");
        Map<EventType, Integer> benefitMap = new HashMap<>();
        benefitMap.put(EventType.WeekendEvent, amount);
        return benefitMap;
    }
    @Override
    public void updateClientBenefit(Client client) {
        client.joinEvent();
        int amount = 2023 * client.getMenuOrders().getValueSumByMenu("메인");
        client.addBenefitToTotalDiscountAmount(amount);
        client.addBenefitToTotalEventAmount(amount);
    }
}
