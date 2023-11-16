package christmas.back.domain.event.discount;

import christmas.back.domain.event.config.BaseEvent;
import christmas.back.domain.event.config.EventType;
import christmas.back.domain.order.MenuOrders;
import christmas.back.domain.user.model.Client;
import java.util.HashMap;
import java.util.Map;

public class DdayEvent extends BaseEvent {
    private static final Integer D_DAY_BASE_MONEY = 1000;
    private static final Integer D_DAY_BASE_DAY = 25;
    @Override
    public Boolean canGetEvent(Client client , MenuOrders menuOrders) {
        return client.canGetEventByCheckDDay(D_DAY_BASE_DAY);
    }
    @Override
    public Map<EventType,Integer> getEventBenefit(Client client,MenuOrders menuOrders) {
        int amount = eventBenefitCalculate(client.getVisitDay());
        Map<EventType, Integer> benefitMap = new HashMap<>();
        benefitMap.put(EventType.DDayEvent, amount);
        return benefitMap;
    }
    @Override
    public void updateClientBenefit(Client client,MenuOrders menuOrders) {
        client.joinEvent();
        int benefit = eventBenefitCalculate(client.getVisitDay());
        client. addBenefitToTotalDiscountAndEventBenefit(benefit);
    }
    public Integer eventBenefitCalculate(Integer givenDay){
        return D_DAY_BASE_MONEY + (givenDay - 1) * 100;
    }
}
