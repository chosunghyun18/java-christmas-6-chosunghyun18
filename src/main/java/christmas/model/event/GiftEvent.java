package christmas.model.event;

import christmas.model.User.Client;
import java.util.HashMap;
import java.util.Map;

public class GiftEvent extends BaseEvent{
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
            return "샴페인";
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
