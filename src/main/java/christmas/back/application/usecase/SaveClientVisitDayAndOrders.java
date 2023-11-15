package christmas.back.application.usecase;

import christmas.back.application.service.ClientService;
import christmas.back.application.service.MenuOrderService;
import christmas.back.domain.order.MenuOrders;
import christmas.back.domain.user.model.Client;

public class SaveClientVisitDayAndOrders {
    private final ClientService clientService;
    private final MenuOrderService menuOrderService;

    public SaveClientVisitDayAndOrders(ClientService clientService,MenuOrderService menuOrderService) {
        this.clientService = clientService;
        this.menuOrderService = menuOrderService;
    }

    public Long execute(Integer visitDay, MenuOrders menuOrders) {
        menuOrders = menuOrderService.saveOrders(menuOrders);
        return clientService.saveClient(new Client(visitDay,menuOrders)).getId();
    }
}
