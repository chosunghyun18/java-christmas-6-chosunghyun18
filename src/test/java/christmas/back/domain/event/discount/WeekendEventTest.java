package christmas.back.domain.event.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import christmas.back.domain.event.config.EventType;
import christmas.back.domain.order.MenuOrders;
import christmas.back.domain.user.model.Client;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekendEventTest {
    private WeekendEvent weekendEvent;
    private Client client;
    private MenuOrders menuOrders;

    @BeforeEach
    public void setUp() {
        List<Integer> eventDays = Arrays.asList(5, 6);
        weekendEvent = new WeekendEvent(eventDays);
        client = mock(Client.class);
        menuOrders = mock(MenuOrders.class);
    }

    @Test
    @DisplayName("주말 이벤트 - 매칭하는 날짜와 주문 메뉴 확인하여 참여 가능 여부 테스트")
    public void testCanGetEventForMatchingDayAndMenu() {
        when(client.getVisitDay()).thenReturn(5);
        when(menuOrders.isOrderHaveMenu("메인")).thenReturn(true);

        boolean canGetEvent = weekendEvent.canGetEvent(client, menuOrders);
        assertTrue(canGetEvent);
    }

    @Test
    @DisplayName("주말 이벤트 - 매칭하지 않는 날짜 또는 주문 메뉴가 없어서 참여 불가능 여부 테스트")
    public void testCannotGetEventForNonMatchingDayOrNoMenu() {
        when(client.getVisitDay()).thenReturn(3);
        when(menuOrders.isOrderHaveMenu("메인")).thenReturn(false);

        boolean canGetEvent = weekendEvent.canGetEvent(client, menuOrders);
        assertFalse(canGetEvent);
    }

    @Test
    @DisplayName("주말 이벤트 혜택 확인 테스트")
    public void testGetEventBenefit() {
        when(menuOrders.getValueSumByMenu("메인")).thenReturn(3);

        Map<EventType, Integer> eventBenefit = weekendEvent.getEventBenefit(client, menuOrders);
        assertEquals(1, eventBenefit.size());
        assertEquals(WeekendEvent.WEEKEND_EVENT_BENEFIT_VALUE * 3, eventBenefit.get(EventType.WeekendEvent));
    }

    @Test
    @DisplayName("클라이언트 혜택 업데이트 확인 테스트")
    public void testUpdateClientBenefit() {
        when(menuOrders.getValueSumByMenu("메인")).thenReturn(4);

        weekendEvent.updateClientBenefit(client, menuOrders);
        verify(client).joinEvent();
        verify(client).addBenefitToTotalDiscountAndEventBenefit(WeekendEvent.WEEKEND_EVENT_BENEFIT_VALUE * 4);
    }
}