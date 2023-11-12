package christmas.controller;

import christmas.model.User.Client;
import christmas.model.event.ChristmasPromotion;

public class PlannerController {
    private final IOController ioController;
    private final ChristmasPromotion christmasPromotion;
    private final Client client;
    public PlannerController() {
        this.ioController = new IOController();
        this.christmasPromotion = new ChristmasPromotion();
        this.client = new Client(ioController.getVisitDay(),ioController.readMenuAndAmount());
    }

    public void startPlanner() {
        ioController.showEventDayIntroMessage(client.getVisitDay());
        ioController.showOrderCompleteMessage(client.getMenuOrders());
    }

    public void showBeforeDisCount() {
        ioController.showBeforeDisCountMessage(client.getTotalAmountBeforeDiscount());
    }

    public void showEventMenu() {
        ioController.showExtraItemEventMessage(christmasPromotion.canGetGiftEvent(client));
    }

    public void showEventItemsResult() {
        ioController.showEventItemsHeaderMessage();
        checkDiscountEvent();
        checkGiftEvent();
        if (client.getNoEvent()) {
            ioController.showNoResultMessage();
        }
        ioController.showLine();
    }

    public void showTotalDiscount() {
        ioController.showTotalDiscountMessage(client.getTotalDiscountAmount());
    }

    public void showAfterDiscount() {
        ioController.showAfterDiscount(client.getAfterDiscount());
    }

    public void showBadge() {
        ioController.showEventBadge(client.getBadge());
    }
    private void checkGiftEvent(){
        if (christmasPromotion.canGetGiftEvent(client)) {
            ioController.showGetEventMenuDisCount();
        }
    }
    private void checkDiscountEvent() {
        if (christmasPromotion.canGetDDayEvent(client)) {
            ioController.showDdayDiscount(christmasPromotion.getDDayEventBenefit(client));
        }
        if (christmasPromotion.canGetWeekEvent(client)) {
            ioController.showWeekDiscount(christmasPromotion.getWeekEventBenefit(client));
        }
        if (christmasPromotion.canGetWeekendEvent(client)) {
            ioController.showWeekendDiscount(christmasPromotion.getWeekendEventBenefit(client));
        }
        if (christmasPromotion.canGetSpecialEvent(client)) {
            ioController.showSpecialDiscount();
        }
    }
}
