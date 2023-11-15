package christmas;

import christmas.front.controller.IOController;
import christmas.back.controller.PlannerController;
import christmas.front.view.InputView;
import christmas.front.view.OutputView;

public class Application {
    public static void main(String[] args) {
        IOController ioController = new IOController(new InputView(),new OutputView());
        PlannerController plannerController = new PlannerController(ioController);
        plannerController.startPlanner();
        plannerController.showOrderResult();
    }
}
