package christmas.back.domain.event.discount;

import christmas.back.domain.event.config.BaseEvent;
import christmas.back.domain.event.config.EventType;
import christmas.back.domain.order.MenuOrders;
import christmas.back.domain.user.model.Client;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpecialEvent extends BaseEvent {
    private final List<Integer> days;

    public SpecialEvent(List<Integer> days) {
        this.days = days;
    }
    @Override
    public Boolean canGetEvent(Client client, MenuOrders menuOrders) {
        return days.contains(client.getVisitDay());
    }
    @Override
    public Map<EventType,Integer> getEventBenefit(Client client,MenuOrders menuOrders) {
        int amount = 1000;
        Map<EventType, Integer> benefitMap = new HashMap<>();
        benefitMap.put(EventType.SpecialEvent, amount);
        return benefitMap;
    }
    @Override
    public void updateClientBenefit(Client client,MenuOrders menuOrders) {
        client.joinEvent();
        int amount = 1000;
        client.addBenefitToTotalDiscountAmount(amount);
        client.addBenefitToTotalEventAmount(amount);
    }
}
