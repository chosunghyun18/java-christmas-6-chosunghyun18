package christmas.front.controller;

import christmas.back.domain.event.config.EventType;
import christmas.back.domain.order.MenuOrders;
import christmas.front.view.InputView;
import christmas.front.view.OutputView;
import java.util.List;
import java.util.Map;

public class IOController {
    private final InputView inputView;
    public final OutputView outputView;

    public IOController(InputView inputView ,OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
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
            MenuOrders orders = new MenuOrders(InputValidate.orderCheck(order));
            showEventApplyMessaged(orders);
            return orders;
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readMenuAndAmount();
        }
    }

    private void showEventApplyMessaged(MenuOrders orders) {
        if(orders.canNotGetEvent()) {
            outputView.showEventDenyMessage();
            outputView.showDelimeterLineInPlanner();
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

    public void showExtraItemEventMessage(String showExtra) {
        outputView.showExtraItemEventMessage(showExtra);
    }
    public void  showEventItemsHeaderMessage(){
        outputView.showEventItemsHeaderMessage();
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

    public void showBenefit(List<Map<EventType,Integer>> benefit) {
        if(benefit.isEmpty()) {
            showNoBenefit();
        return;
        }
        benefit.forEach(this::showSingleBenefit);
    }
    private void showSingleBenefit(Map<EventType,Integer> benefit){
        Map.Entry<EventType, Integer> entry = benefit.entrySet().iterator().next();
        EventType benefitType = entry.getKey();
        Integer benefitAmount = entry.getValue();
        outputView.showBenefitByType(benefitType,benefitAmount);
    }

    public void showNoBenefit() {
        outputView.showNoEventResult();
    }
}
