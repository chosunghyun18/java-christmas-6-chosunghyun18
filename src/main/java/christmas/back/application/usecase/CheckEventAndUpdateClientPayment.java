package christmas.back.application.usecase;

import christmas.back.application.service.ClientService;
import christmas.back.application.service.MenuOrderService;
import christmas.back.domain.event.config.BaseEvent;
import christmas.back.domain.event.config.EventConfig;
import christmas.back.domain.event.config.EventType;
import christmas.back.domain.order.MenuOrders;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class CheckEventAndUpdateClientPayment {
    private final MenuOrderService menuOrderService;
    private final ClientService clientService;
    private final List<BaseEvent> events;

    public CheckEventAndUpdateClientPayment(ClientService clientService,MenuOrderService menuOrderService) {
        this.events = EventConfig.configEvent();
        this.menuOrderService = menuOrderService;
        this.clientService = clientService;
    }
    public List<Map<EventType,Integer>> execute(Long clientId) {
        var client = clientService.findClientById(clientId);
        List<Map<EventType,Integer>> output  = new ArrayList<>();
        MenuOrders menuOrders = menuOrderService.findMenuOrdersById(client.getMenuOrdersId());
        events.forEach(event ->{
            if(event.canGetEvent(client,menuOrders)) {
                output.add(event.getEventBenefit(client,menuOrders));
                event.updateClientBenefit(client,menuOrders);
            }
        });
        return output;
    }
}
