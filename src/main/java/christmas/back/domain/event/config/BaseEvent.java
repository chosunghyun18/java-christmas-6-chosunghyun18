package christmas.back.domain.event.config;

import christmas.back.domain.user.model.Client;
import java.util.Map;

public class BaseEvent {
    public Boolean canGetEvent(Client client) {
        return null;
    }
    public Map<EventType,Integer> getEventBenefit(Client client) {
        return null;
    }

    public void updateClientBenefit(Client client) {

    }
}
