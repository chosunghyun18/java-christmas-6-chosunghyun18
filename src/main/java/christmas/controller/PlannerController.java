package christmas.controller;

import christmas.model.DdayEvent;
import christmas.model.SpecialEvent;
import christmas.model.Week;
import christmas.model.Weekend;
import christmas.view.OutputView;
import java.util.List;

public class PlannerController {
    private final IOController ioController;
    private final Week week;
    private final Weekend weekend; // 주말
    private final SpecialEvent specialEvent;
    private final DdayEvent dDayEvent;
    private Integer visitDay ;

    public PlannerController() {
        this.ioController = new IOController();
        this.week = new Week(List.of(3,4,5,6,7,10,11,12,13,14,17,18,19,20,21,24,25,26,27,28,31));
        this.weekend = new Weekend(List.of(1,2,8,9,15,16,22,23,29,30));
        this.specialEvent = new SpecialEvent(List.of(3,10,17,24,25,31));
        this.dDayEvent = new DdayEvent();
    }

    public void startPlanner() {
        this.visitDay = ioController.getVisitDay();
        MenuOrders orders = ioController.readMenuAndAmount();
    }
}
