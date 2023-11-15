package christmas.back.controller;

import christmas.back.application.service.ClientService;
import christmas.back.application.service.MenuOrderService;
import christmas.back.application.usecase.CheckEventAndUpdateClientPayment;
import christmas.back.application.usecase.SaveClientVisitDayAndOrders;
import christmas.front.controller.IOController;

public class PlannerController {
    private final IOController ioController;
    private Long clientId;
    private final SaveClientVisitDayAndOrders saveClientVisitDayAndOrders;
    private final CheckEventAndUpdateClientPayment checkEventAndUpdateClientPayment;
    private final ClientService clientService;

    public PlannerController(IOController ioController, ClientService clientService,
                             MenuOrderService menuOrderService) {
        this.ioController = ioController;
        this.clientService = clientService;
        this.saveClientVisitDayAndOrders = new SaveClientVisitDayAndOrders(clientService, menuOrderService);
        this.checkEventAndUpdateClientPayment = new CheckEventAndUpdateClientPayment(clientService, menuOrderService);
    }

    public void startPlanner() {
        var visitDay = ioController.getVisitDay();
        var menuOrders = ioController.readMenuAndAmount();
        this.clientId = saveClientVisitDayAndOrders.execute(visitDay, menuOrders);
        ioController.showEventDayIntroMessage(visitDay);
        ioController.showOrderCompleteMessage(menuOrders);
    }

    public void showBeforeDisCount() {
        ioController.showBeforeDisCountMessage(clientService.getTotalAmountBeforeDiscount(clientId));
    }

    public void showGiftEventMenu() {
        ioController.showExtraItemEventMessage(clientService.getGiftEventMenu(clientId));
    }

    public void showEventItemsResult() {
        ioController.showEventItemsHeaderMessage();
        checkEvent();
        ioController.showLine();
    }

    public void showTotalDiscount() {
        ioController.showTotalDiscountMessage(clientService.getTotalDiscountAmount(clientId));
    }

    public void showAfterDiscount() {
        ioController.showAfterDiscount(clientService.getAfterDiscount(clientId));
    }

    public void showBadge() {
        clientService.updateBadge(clientId);
        ioController.showEventBadge(clientService.getBadgeContent(clientId));
    }

    private void checkEvent() {
        var result = checkEventAndUpdateClientPayment.execute(clientId);
        ioController.showBenefit(result);
    }

    public void showOrderResult() {
        showBeforeDisCount();
        showGiftEventMenu();
        showEventItemsResult();
        showTotalDiscount();
        showAfterDiscount();
        showBadge();
    }
}
