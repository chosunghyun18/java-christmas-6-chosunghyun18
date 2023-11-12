package christmas.model.event;

import christmas.model.User.Client;
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
