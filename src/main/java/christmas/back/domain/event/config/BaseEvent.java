package christmas.back.domain.event.config;

import christmas.back.domain.order.MenuOrders;
import christmas.back.domain.user.model.Client;
import java.util.Map;

public class BaseEvent {
    public Boolean canGetEvent(Client client, MenuOrders menuOrders) {
        return null;
    }
    public Map<EventType,Integer> getEventBenefit(Client client,MenuOrders menuOrders) {
        return null;
    }

    public void updateClientBenefit(Client client,MenuOrders menuOrders) {

    }
}
