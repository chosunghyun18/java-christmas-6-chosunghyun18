package christmas.view;

import christmas.controller.MenuOrders;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {
    public void printMenu() {
        System.out.println("<주문 메뉴>");
    }

    public void printError(String message) {
        System.out.println("[ERROR] "+message);
    }

    public void showEventDayIntroMessage(Integer visitDay) {
        System.out.println("12월 "+visitDay+"일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println("");

    }

    public void showOrderCompleteMessage(MenuOrders givenOrder) {
        System.out.println("<주문 메뉴>");
        List<Map<String, Integer>> orders = givenOrder.getOrderForMessage();
        orders.forEach(order -> order.forEach((itemName, quantity) ->
                System.out.println(itemName + " " + quantity + "개"))
        );
    }

    public void showBeforeDisCountMessage(Integer beforeDiscount) {
        System.out.println("<할인 전 총주문 금액>");
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String formattedNumber = decimalFormat.format(beforeDiscount);
        System.out.println(formattedNumber);
    }
}
