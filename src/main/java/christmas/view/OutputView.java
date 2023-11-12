package christmas.view;

import christmas.model.event.EventType;
import christmas.model.order.MenuOrders;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {
    public void printMenuHead() {
        System.out.println("<주문 메뉴>");
    }

    public void printError(String message) {
        System.out.println("[ERROR] " + message);
    }

    public void showEventDayIntroMessage(Integer visitDay) {
        System.out.println("12월 " + visitDay + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        showDelimeterLineInPlanner();

    }

    public void showOrderCompleteMessage(MenuOrders givenOrder) {
        printMenuHead();
        List<Map<String, Integer>> orders = givenOrder.getOrderForMessage();
        orders.forEach(order -> order.forEach((itemName, quantity) ->
                System.out.println(itemName + " " + quantity + "개"))
        );
        showDelimeterLineInPlanner();
    }

    public void showBeforeDisCountMessage(Integer beforeDiscount) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(getForMatedNumber(beforeDiscount) + "원");
        showDelimeterLineInPlanner();
    }

    public void showExtraItemEventMessage(String showExtra) {
        System.out.println("<증정 메뉴>");
        if (showExtra.equals("없음")) {
            showNoEventResult();
            showDelimeterLineInPlanner();
            return;
        }
        System.out.println(showExtra + " 1개");
        showDelimeterLineInPlanner();
    }

    public void showDelimeterLineInPlanner() {
        System.out.println("");
    }

    private void showNoEventResult() {
        System.out.println("없음");
    }

    public void showEventItemsHeaderMessage() {
        System.out.println("<혜택 내역>");
    }

    public void showNoResultMessage() {
        System.out.println("없음");
    }
    private String getForMatedNumber(Integer given) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(given);
    }

    public void showTotalDiscountMessage(Integer totalAmount) {
        System.out.println("<총혜택 금액>");
        if (totalAmount.equals(0)) {
            System.out.println("0원");
            showDelimeterLineInPlanner();
            return;
        }
        System.out.println("-" + getForMatedNumber(totalAmount) + "원");
        showDelimeterLineInPlanner();
    }

    public void showAfterDiscount(Integer money) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(getForMatedNumber(money) + "원");
        showDelimeterLineInPlanner();
    }

    public void showEventBadge(String badge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge);
        showDelimeterLineInPlanner();
    }

    public void showBenfitByType(EventType benefitType, Integer benefitAmount) {
        if (benefitType.equals(EventType.DdayEvent)) {
            showDdayDiscount(benefitAmount);
            return;
        }
        if (benefitType.equals(EventType.WeekEvent)) {
            showWeekDiscount(benefitAmount);
            return;
        }
        if (benefitType.equals(EventType.WeekendEvent)) {
            showWeekendDiscount(benefitAmount);
            return;
        }
        if (benefitType.equals(EventType.SpecialEvent)) {
            showSpecialDiscount();
            return;
        }
        if (benefitType.equals(EventType.GiftEvent)) {
            showGetEventMenuDisCount();
            return;
        }
        showNoEventResult();
    }

    public void showDdayDiscount(Integer discountAmount) {
        System.out.println("크리스마스 디데이 할인: -" + getForMatedNumber(discountAmount) + "원");
    }

    private void showSpecialDiscount() {
        Integer specialDiscountAmount = 1000;
        System.out.println("특별 할인: -" + getForMatedNumber(specialDiscountAmount) + "원");
    }

    private void showWeekendDiscount(Integer weekendDiscountAmount) {
        System.out.println("주말 할인: -" + getForMatedNumber(weekendDiscountAmount) + "원");
    }

    private void showWeekDiscount(Integer weekDiscountAmount) {
        System.out.println("평일 할인: -" + getForMatedNumber(weekDiscountAmount) + "원");
    }

    private void showGetEventMenuDisCount() {
        Integer specialGiftPrice = 25000;
        System.out.println("증정 이벤트: -" + getForMatedNumber(specialGiftPrice) + "원");
    }

    public void showEventDenyMessage() {
        System.out.println("주문 금액 10,000원 이상부터 이벤트가 적용됩니다.");
    }
}
