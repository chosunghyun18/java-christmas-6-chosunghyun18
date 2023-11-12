package christmas.controller;

import christmas.model.order.MenuOrders;
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

    public void showEventDayIntroMessage(Integer visitDay) {
        outputView.showEventDayIntroMessage(visitDay);
    }

    public void showOrderCompleteMessage(MenuOrders orders) {
        outputView.showOrderCompleteMessage(orders);
    }

    public void showBeforeDisCountMessage(Integer beforeDiscount) {
        outputView.showBeforeDisCountMessage(beforeDiscount);
    }

    public void showExtraItemEventMessage(boolean showExtra) {
        outputView.showExtraItemEventMessage(showExtra);
    }
    public void  showEventItemsHeaderMessage(){
        outputView.showEventItemsHeaderMessage();
    }
    public void showNoResultMessage() {
        outputView.showNoResultMessage();
    }

    public void showDdayDiscount(Integer discountAmount) {
        outputView.showDdayDiscount(discountAmount);
    }

    public void showWeekDiscount(Integer benefit) {
        outputView.showWeekDiscount(benefit);
    }

    public void showWeekendDiscount(Integer benefit) {
        outputView.showWeekendDiscount(benefit);
    }

    public void showSpecialDiscount() {
        outputView.showSpecialDiscount();
    }

    public void showGetEventMenuDisCount() {
        outputView.showGetEventMenuDisCount();
    }
    public void showTotalDiscountMessage(Integer totalAmount) {
        outputView.showTotalDiscountMessage(totalAmount);
    }

    public void showAfterDiscount(Integer money) {
        outputView.showAfterDiscount(money);
    }

    public void showEventBadge(String badge) {
        outputView.showEventBadge(badge);
    }

    public void showLine() {
        outputView.showDelimeterLineInPlanner();
    }
}
