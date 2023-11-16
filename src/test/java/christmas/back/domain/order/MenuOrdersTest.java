package christmas.back.domain.order;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import christmas.back.domain.menu.MenuItem;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuOrdersTest {
    private MenuOrders menuOrders;

    @BeforeEach
    public void setUp() {
        Map<MenuItem, Integer> orders = new HashMap<>();
        orders.put(MenuItem.APPETIZER_BUTTON_MUSHROOM_SOUP, 2);
        orders.put(MenuItem.MAIN_T_BONE_STEAK, 1);
        orders.put(MenuItem.DESSERT_CHOCO_CAKE, 3);
        menuOrders = new MenuOrders(orders);
    }

    @Test
    @DisplayName("주문 메뉴 확인 - 메뉴가 있는 경우")
    public void testIsOrderHaveMenuWithExistingMenu() {
        boolean hasMenu = menuOrders.isOrderHaveMenu("애피타이저");
        assertTrue(hasMenu);
    }

    @Test
    @DisplayName("주문 메뉴 확인 - 메뉴가 없는 경우")
    public void testIsOrderHaveMenuWithNonExistingMenu() {
        boolean hasMenu = menuOrders.isOrderHaveMenu("피자");
        assertFalse(hasMenu);
    }

    @Test
    @DisplayName("메뉴 주문 합계 확인")
    public void testGetValueSumByMenu() {
        int sum = menuOrders.getValueSumByMenu("메인");

    }

    @Test
    @DisplayName("이벤트 참여 가능 여부 확인")
    public void testCanNotGetEvent() {
        boolean canNotGetEvent = menuOrders.canNotGetEvent();
        assertFalse(canNotGetEvent);
    }
}