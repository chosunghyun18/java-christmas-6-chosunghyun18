package christmas.controller;

import christmas.model.User.Client;
import christmas.model.event.BaseEvent;
import christmas.model.event.EventConfig;
import christmas.model.event.GiftEvent;

import java.util.List;

public class PlannerController {
    private final IOController ioController;
    private final Client client;
    private final List<BaseEvent> events;

    public PlannerController(IOController ioController) {
        this.events = EventConfig.configEvent();
        this.ioController = ioController;
        this.client = new Client(ioController.getVisitDay(),ioController.readMenuAndAmount());
    }

    public void startPlanner() {
        ioController.showEventDayIntroMessage(client.getVisitDay());
        ioController.showOrderCompleteMessage(client.getMenuOrders());
    }

    public void showBeforeDisCount() {
        ioController.showBeforeDisCountMessage(client.getTotalAmountBeforeDiscount());
    }

    public void showGiftEventMenu() {
        ioController.showExtraItemEventMessage(GiftEvent.getGiftMenu(client));
    }

    public void showEventItemsResult() {
        ioController.showEventItemsHeaderMessage();
        checkEvent();
        ioController.showLine();
    }

    public void showTotalDiscount() {
        ioController.showTotalDiscountMessage(client.getTotalDiscountAmount());
    }

    public void showAfterDiscount() {
        ioController.showAfterDiscount(client.getAfterDiscount());
    }

    public void showBadge() {
        client.applyBadge();
        ioController.showEventBadge(client.getBadge());
    }
    private void checkEvent() {
        events.forEach(event ->{
            if(event.canGetEvent(client)){
                ioController.showBenefit(event.getEventBenefit(client));
                event.updateClientBenefit(client);
            }
        });
        if(client.isNotJoinEvent()){
            ioController.showNoBenefit();
        }
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
