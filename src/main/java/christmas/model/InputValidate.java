package christmas.model;

import christmas.controller.MenuOrders;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputValidate {
    public static void numberCheck(String givenDate) {
        try {
            Integer.parseInt(givenDate);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public static void dateRangeCheck(Integer givenDate) {
        if (givenDate > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        if (givenDate < 0) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public static Map<MenuItem, Integer> orderCheck(String order) {
        List<String> orderString = inputFormCheck(order);
        isMenu(orderString);
        return menuAmountDuplicateCheck(orderString);
    }

    private static List<String> inputFormCheck(String given) {
        List<String> result = List.of(given.split(","));
        for (String item : result) {
            if (!item.contains("-")) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
        return result;
    }

    private static void isMenu(List<String> orderString) {
        for (String item : orderString) {
            String menuCandiate = item.substring(0, item.lastIndexOf("-"));
            if (MenuItem.isNotMenu(menuCandiate)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    private static Map<MenuItem, Integer> menuAmountDuplicateCheck(List<String> orderString) {
        Map<MenuItem, Integer> orders = new HashMap();
        for (String item : orderString) {

            String[] order = item.split("-");
            MenuItem menuName = MenuItem.getMenuByName(order[0]);
            Integer menuAmount = stingToNumberCheck(order[1]);

            if (menuAmount < 0) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
            if (orders.containsKey(menuName)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
            orders.put(menuName, menuAmount);
        }
        return orders;
    }

    private static Integer stingToNumberCheck(String given) {
        Integer amount = 0;
        try {
            amount = Integer.parseInt(given);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        return amount;
    }

}
