package christmas.back.domain.event.discount;

import christmas.back.domain.event.config.BaseEvent;
import christmas.back.domain.event.config.EventType;
import christmas.back.domain.order.MenuOrders;
import christmas.back.domain.user.model.Client;
import java.util.HashMap;
import java.util.Map;

public class DdayEvent extends BaseEvent {
    private final Integer day = 25;
    @Override
    public Boolean canGetEvent(Client client , MenuOrders menuOrders) {
        if(client.getVisitDay() <= day) {
            return true;
        }
        return false;
    }
    @Override
    public Map<EventType,Integer> getEventBenefit(Client client,MenuOrders menuOrders) {
        int amount = 1000 + (client.getVisitDay() - 1) * 100;
        Map<EventType, Integer> benefitMap = new HashMap<>();
        benefitMap.put(EventType.DDayEvent, amount);
        return benefitMap;
    }
    @Override
    public void updateClientBenefit(Client client,MenuOrders menuOrders) {
        client.joinEvent();
        int amount = 1000 + (client.getVisitDay() - 1) * 100;
        client.addBenefitToTotalDiscountAmount(amount);
        client.addBenefitToTotalEventAmount(amount);
    }
}
