package christmas.controller;

import christmas.model.InputValidate;
import christmas.view.InputView;
import christmas.view.OutputView;

public class IOController {
    private final InputView inputView;
    public final OutputView outputView;

    public IOController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public Integer getVisitDay() {
        String givenDate = inputView.readDate();
        try {
            InputValidate.numberCheck(givenDate);
            Integer result = Integer.parseInt(givenDate);
            InputValidate.dateRangeCheck(result);
            return result;
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getVisitDay();
        }
    }

    public MenuOrders readMenuAndAmount() {
        String order = inputView.readMenuAndAmount();
        try {
            return new MenuOrders(InputValidate.orderCheck(order));
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readMenuAndAmount();
        }
    }
}
