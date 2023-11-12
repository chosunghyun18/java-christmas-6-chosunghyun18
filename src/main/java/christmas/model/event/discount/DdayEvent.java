package christmas.model.event.discount;

import christmas.model.User.Client;
import christmas.model.event.BaseEvent;
import christmas.model.event.EventType;
import java.util.HashMap;
import java.util.Map;

public class DdayEvent extends BaseEvent {
    private final Integer day = 25;
    @Override
    public Boolean canGetEvent(Client client) {
        if(client.getVisitDay() <= day) {
            return true;
        }
        return false;
    }
    @Override
    public Map<EventType,Integer> getEventBenefit(Client client) {
        int amount = 1000 + (client.getVisitDay() - 1) * 100;
        Map<EventType, Integer> benefitMap = new HashMap<>();
        benefitMap.put(EventType.DdayEvent, amount);
        return benefitMap;
    }
    @Override
    public void updateClientBenefit(Client client) {
        client.joinEvent();
        int amount = 1000 + (client.getVisitDay() - 1) * 100;
        client.addBenefitToTotalDiscountAmount(amount);
        client.addBenefitToTotalEventAmount(amount);
    }
}
