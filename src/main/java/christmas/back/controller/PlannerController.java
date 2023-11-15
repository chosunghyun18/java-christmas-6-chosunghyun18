package christmas.back.controller;

import christmas.back.domain.event.config.BaseEvent;
import christmas.back.domain.event.config.EventConfig;
import christmas.back.domain.event.gift.GiftEvent;
import christmas.back.domain.user.model.Client;

import christmas.front.controller.IOController;
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
        ioController.showEventBadge(client.getBadgeContent());
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
