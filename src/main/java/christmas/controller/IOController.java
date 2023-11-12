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

    public void showDdayDiscount(Integer visitDay) {
        Integer discountAmount = 1000 + (visitDay-1)*100;
        outputView.showDdayDiscount(discountAmount);
    }

    public void showWeekDiscount(MenuOrders menuOrders) {
        outputView.showWeekDiscount(menuOrders.getWeekDiscountAmount());
    }

    public void showWeekendDiscount(MenuOrders menuOrders) {
        outputView.showWeekendDiscount(menuOrders.getWeekendDiscountAmount());
    }

    public void showSpecialDiscount() {
        outputView.showSpecialDiscount();
    }

    public void showGetEventMenuDisCount() {
        outputView.showGetEventMenuDisCount();
    }
}
