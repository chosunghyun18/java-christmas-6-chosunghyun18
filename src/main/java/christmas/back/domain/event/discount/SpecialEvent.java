package christmas.back.domain.event.discount;

import christmas.back.domain.event.config.BaseEvent;
import christmas.back.domain.event.config.EventType;
import christmas.back.domain.order.MenuOrders;
import christmas.back.domain.user.model.Client;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpecialEvent extends BaseEvent {
    private static final Integer SPECIAL_EVENT_BENEFIT_VALUE = 1000;
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
        Map<EventType, Integer> benefitMap = new HashMap<>();
        benefitMap.put(EventType.SpecialEvent,SPECIAL_EVENT_BENEFIT_VALUE);
        return benefitMap;
    }
    @Override
    public void updateClientBenefit(Client client,MenuOrders menuOrders) {
        client.joinEvent();
        client. addBenefitToTotalDiscountAndEventBenefit(SPECIAL_EVENT_BENEFIT_VALUE);
    }
}
