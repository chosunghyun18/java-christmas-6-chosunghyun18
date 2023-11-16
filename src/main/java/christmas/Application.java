package christmas;

import christmas.back.application.service.ClientService;
import christmas.back.application.service.MenuOrderService;
import christmas.front.controller.IOController;
import christmas.back.controller.PlannerController;
import christmas.front.view.InputView;
import christmas.front.view.OutputView;

public class Application {
    public static void main(String[] args) {
        var clientService = new ClientService();
        var menuOrderService = new MenuOrderService();
        var ioController = new IOController(new InputView(),new OutputView());
        PlannerController plannerController = new PlannerController(ioController,clientService,menuOrderService);
        plannerController.startPlanner();
        plannerController.showOrderResult();
    }
}
