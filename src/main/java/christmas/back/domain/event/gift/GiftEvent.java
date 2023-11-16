package christmas.back.domain.event.gift;

import christmas.back.domain.event.config.BaseEvent;
import christmas.back.domain.order.MenuOrders;
import christmas.back.domain.user.model.Client;
import christmas.back.domain.event.config.EventType;
import christmas.back.domain.menu.MenuItem;
import java.util.HashMap;
import java.util.Map;

public class GiftEvent extends BaseEvent {
    private static final Integer GIFT_EVENT_BENEFIT_VALUE = 25000;
    private static final Integer DECEMBER_GIFT_EVENT_MIN_MONEY = 120000;
    public static String getGiftMenu(Client client) {
        if (client.checkCanGetEvent(DECEMBER_GIFT_EVENT_MIN_MONEY)) {
            return MenuItem.BEVERAGE_CHAMPAGNE.getItemName();
        }
        return "없음";
    }
    @Override
    public Boolean canGetEvent(Client client, MenuOrders menuOrders) {
        return client.checkCanGetEvent(DECEMBER_GIFT_EVENT_MIN_MONEY);
    }
    @Override
    public Map<EventType, Integer> getEventBenefit(Client client,MenuOrders menuOrders) {
        Map<EventType, Integer> benefitMap = new HashMap<>();
        benefitMap.put(EventType.GiftEvent,GIFT_EVENT_BENEFIT_VALUE);
        return benefitMap;
    }
    @Override
    public void updateClientBenefit(Client client,MenuOrders menuOrders) {
        client.joinEvent();
        client.addBenefitToTotalEventAmount(GIFT_EVENT_BENEFIT_VALUE);
    }
}
