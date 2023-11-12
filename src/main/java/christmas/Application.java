package christmas;

import christmas.controller.IOController;
import christmas.controller.PlannerController;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        IOController ioController = new IOController(new InputView(),new OutputView());
        PlannerController plannerController = new PlannerController(ioController);
        plannerController.startPlanner();
        plannerController.showOrderResult();
    }
}
