package christmas;

import christmas.controller.PlannerController;

public class Application {
    public static void main(String[] args) {
        PlannerController plannerController = new PlannerController();
        plannerController.startPlanner();
        plannerController.showBeforeDisCount();
        plannerController.showEventMenu();
        plannerController.showEventItemsResult();
        plannerController.showTotalDiscount();
        plannerController.showAfterDiscount();
        plannerController.showBadge();
    }
}
