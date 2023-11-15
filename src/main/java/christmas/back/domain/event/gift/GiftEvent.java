package christmas.back.domain.event.gift;

import christmas.back.domain.event.config.BaseEvent;
import christmas.back.domain.user.model.Client;
import christmas.back.domain.event.config.EventType;
import christmas.back.domain.menu.MenuItem;
import java.util.HashMap;
import java.util.Map;

public class GiftEvent extends BaseEvent {
    @Override
    public Boolean canGetEvent(Client client) {
        return client.getTotalAmountBeforeDiscount() >= 120000;
    }
    @Override
    public Map<EventType, Integer> getEventBenefit(Client client) {
        int amount = 25000;
        Map<EventType, Integer> benefitMap = new HashMap<>();
        benefitMap.put(EventType.GiftEvent, amount);
        return benefitMap;
    }
    public static String getGiftMenu(Client client) {
        if (client.getTotalAmountBeforeDiscount() >= 120000) {
            return MenuItem.BEVERAGE_CHAMPAGNE.getItemName();
        }
        return "없음";
    }
    @Override
    public void updateClientBenefit(Client client) {
        client.joinEvent();
        int amount = 25000;
        client.addBenefitToTotalEventAmount(amount);
    }
}
