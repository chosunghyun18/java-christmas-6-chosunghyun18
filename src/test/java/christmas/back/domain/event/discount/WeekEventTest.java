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

class WeekEventTest {
    private WeekEvent weekEvent;
    private Client client;
    private MenuOrders menuOrders;

    @BeforeEach
    public void setUp() {
        List<Integer> eventDays = Arrays.asList(1, 2, 3, 4, 5);
        weekEvent = new WeekEvent(eventDays);
        client = mock(Client.class);
        menuOrders = mock(MenuOrders.class);
    }

    @Test
    @DisplayName("주중 이벤트 - 매칭하는 날짜와 주문 디저트 확인하여 참여 가능 여부 테스트")
    public void testCanGetEventForMatchingDayAndMenu() {
        when(client.getVisitDay()).thenReturn(3);
        when(menuOrders.isOrderHaveMenu("디저트")).thenReturn(true);

        boolean canGetEvent = weekEvent.canGetEvent(client, menuOrders);
        assertTrue(canGetEvent);
    }

    @Test
    @DisplayName("주중 이벤트 - 매칭하지 않는 날짜 또는 주문 디저트가 없어서 참여 불가능 여부 테스트")
    public void testCannotGetEventForNonMatchingDayOrNoDessert() {
        when(client.getVisitDay()).thenReturn(6);
        when(menuOrders.isOrderHaveMenu("디저트")).thenReturn(false);

        boolean canGetEvent = weekEvent.canGetEvent(client, menuOrders);
        assertFalse(canGetEvent);
    }

    @Test
    @DisplayName("주중 이벤트 혜택 확인 테스트")
    public void testGetEventBenefit() {
        when(menuOrders.getValueSumByMenu("디저트")).thenReturn(2);

        Map<EventType, Integer> eventBenefit = weekEvent.getEventBenefit(client, menuOrders);
        assertEquals(1, eventBenefit.size());
        assertEquals(WeekEvent.WEEK_EVENT_BENEFIT_VALUE * 2, eventBenefit.get(EventType.WeekEvent));
    }

    @Test
    @DisplayName("클라이언트 혜택 업데이트 확인 테스트")
    public void testUpdateClientBenefit() {
        when(menuOrders.getValueSumByMenu("디저트")).thenReturn(3);
        weekEvent.updateClientBenefit(client, menuOrders);
        verify(client).joinEvent();
        verify(client).addBenefitToTotalDiscountAndEventBenefit(WeekEvent.WEEK_EVENT_BENEFIT_VALUE * 3);
    }
}