package christmas.controller;

import christmas.model.DdayEvent;
import christmas.model.SpecialEvent;
import christmas.model.Week;
import christmas.model.Weekend;
import java.util.List;

public class PlannerController {
    private final IOController ioController;
    private final Week week;
    private final Weekend weekend;
    private final SpecialEvent specialEvent;
    private final DdayEvent dDayEvent;
    private Integer visitDay ;
    private MenuOrders menuOrders;
    private Integer beforeDiscount;

    public PlannerController() {
        this.ioController = new IOController();
        this.week = new Week(List.of(3,4,5,6,7,10,11,12,13,14,17,18,19,20,21,24,25,26,27,28,31));
        this.weekend = new Weekend(List.of(1,2,8,9,15,16,22,23,29,30));
        this.specialEvent = new SpecialEvent(List.of(3,10,17,24,25,31));
        this.dDayEvent = new DdayEvent();
    }

    public void startPlanner() {
        this.visitDay = ioController.getVisitDay();
        this.menuOrders = ioController.readMenuAndAmount();
        ioController.showEventDayIntroMessage(visitDay);
        ioController.showOrderCompleteMessage(menuOrders);
    }
    public void showBeforeDisCount(){
        this.beforeDiscount = menuOrders.getTotalAmountBeforeDiscount();
        ioController.showBeforeDisCountMessage(this.beforeDiscount);
    }

    public void showEventMenu() {
        ioController.showExtraItemEventMessage(canGetEventMenu());
    }
    private Boolean canGetEventMenu() {
        return  beforeDiscount >= 120000 ;
    }
    public void showEventItemsResult() {
        System.out.println("<혜택 내역>");
        Boolean getNoEvent = true;
        if(1<= visitDay && visitDay <=25) {
            getNoEvent = false;
            ioController.showDdayDiscount(visitDay);
        }
        if(week.canGetEvent(visitDay) && menuOrders.canGetWeekDiscount()) {
            getNoEvent = false;
            ioController.showWeekDiscount(menuOrders);
        }
        if(weekend.canGetEvent(visitDay)&& menuOrders.canGetWeekendDiscount()) {
            getNoEvent = false;
            ioController.showWeekendDiscount(menuOrders);
        }
        if(specialEvent.canGetEvent(visitDay)) {
            getNoEvent = false;
            ioController.showSpecialDiscount();
        }
        if(canGetEventMenu()){
            getNoEvent = false;
            ioController.showGetEventMenuDisCount();
        }
        if(getNoEvent) ioController.showNoResultMessage();
    }
}
