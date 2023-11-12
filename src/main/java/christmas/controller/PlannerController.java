package christmas.controller;

import christmas.model.event.discount.DdayEvent;
import christmas.model.event.GiftEvent;
import christmas.model.event.discount.WeekEvent;
import christmas.model.event.discount.WeekendEvent;
import christmas.model.order.MenuOrders;
import christmas.model.event.discount.SpecialEvent;
import java.util.List;

public class PlannerController {
    private final IOController ioController;
    private final WeekEvent weekEvent;
    private final WeekendEvent weekendEvent;
    private final SpecialEvent specialEvent;
    private final DdayEvent dDayEvent;
    private final GiftEvent giftEvent;
    private Integer visitDay;
    private MenuOrders menuOrders;
    private Integer beforeDiscount;
    private Boolean getNoEvent ;
    private Integer totalDiscountAmount ;
    private Integer totalEventAmount ;

    public PlannerController() {
        this.ioController = new IOController();
        this.dDayEvent = new DdayEvent();
        this.giftEvent = new GiftEvent();
        this.specialEvent = new SpecialEvent(List.of(3, 10, 17, 24, 25, 31));
        this.weekendEvent = new WeekendEvent(List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30));
        this.weekEvent = new WeekEvent(List.of(3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31));
        this.beforeDiscount = 0 ;
        this.getNoEvent = true;
        this.totalDiscountAmount = 0 ;
        this.totalEventAmount = 0;
    }

    public void startPlanner() {
        this.visitDay = ioController.getVisitDay();
        this.menuOrders = ioController.readMenuAndAmount();
        ioController.showEventDayIntroMessage(visitDay);
        ioController.showOrderCompleteMessage(menuOrders);
    }

    public void showBeforeDisCount() {
        this.beforeDiscount = menuOrders.getTotalAmountBeforeDiscount();
        ioController.showBeforeDisCountMessage(this.beforeDiscount);
    }

    public void showEventMenu() {
        ioController.showExtraItemEventMessage(giftEvent.canGetEvent(beforeDiscount));
    }

    public void showEventItemsResult() {
        ioController.showEventItemsHeaderMessage();
        if (dDayEvent.canGetEvent(visitDay)) {
            getNoEvent = false;
            totalDiscountAmount = dDayEvent.getEventBenefit(visitDay);
            ioController.showDdayDiscount(totalDiscountAmount);
        }
        if (weekEvent.canGetEvent(visitDay,menuOrders)) {
            getNoEvent = false;
            Integer benefit = weekEvent.getEventBenefit(menuOrders);
            ioController.showWeekDiscount(benefit);
            totalDiscountAmount += benefit;
        }
        if (weekendEvent.canGetEvent(visitDay,menuOrders)) {
            getNoEvent = false;
            Integer benefit = weekendEvent.getEventBenefit(menuOrders);
            ioController.showWeekendDiscount(benefit);
            totalDiscountAmount += benefit;
        }
        if (specialEvent.canGetEvent(visitDay)) {
            getNoEvent = false;
            ioController.showSpecialDiscount();
            totalDiscountAmount += 1000;
        }
        if (giftEvent.canGetEvent(beforeDiscount)) {
            getNoEvent = false;
            ioController.showGetEventMenuDisCount();
            totalEventAmount = 25000 + totalDiscountAmount;
        }
        if (getNoEvent) {
            ioController.showNoResultMessage();
        }
        ioController.showLine();
    }

    public void showTotalDiscount() {
        if (getNoEvent) {
            ioController.showTotalDiscountMessage(totalEventAmount);
            return;
        }
        ioController.showTotalDiscountMessage(totalEventAmount);
    }

    public void showAfterDiscount() {
        ioController.showAfterDiscount(beforeDiscount-totalDiscountAmount);
    }

    public void showBedge() {
        ioController.showEventBedge(totalEventAmount);
    }
}
