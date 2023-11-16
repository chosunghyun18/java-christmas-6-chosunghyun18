package christmas.back.domain.event.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import christmas.back.domain.event.config.EventType;
import christmas.back.domain.user.model.Client;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SpecialEventTest {
    private SpecialEvent specialEvent;
    private Client client;

    @BeforeEach
    public void setUp() {
        List<Integer> eventDays = Arrays.asList(10, 20);
        specialEvent = new SpecialEvent(eventDays);
        client = mock(Client.class);
    }

    @Test
    @DisplayName("특별 이벤트 - 매칭하는 날짜에 참여 가능 여부 테스트")
    public void testCanGetEventForMatchingDay() {
        when(client.getVisitDay()).thenReturn(10);
        boolean canGetEvent = specialEvent.canGetEvent(client, null);
        assertTrue(canGetEvent);
    }

    @Test
    @DisplayName("특별 이벤트 - 매칭하지 않는 날짜에 참여 가능 여부 테스트")
    public void testCanGetEventForNonMatchingDay() {
        when(client.getVisitDay()).thenReturn(15);
        boolean canGetEvent = specialEvent.canGetEvent(client, null);
        assertFalse(canGetEvent);
    }

    @Test
    @DisplayName("특별 이벤트 혜택 확인 테스트")
    public void testGetEventBenefit() {
        Map<EventType, Integer> eventBenefit = specialEvent.getEventBenefit(client, null);
        assertEquals(1, eventBenefit.size());
        assertEquals(SpecialEvent.SPECIAL_EVENT_BENEFIT_VALUE, eventBenefit.get(EventType.SpecialEvent));
    }

    @Test
    @DisplayName("클라이언트 혜택 업데이트 확인 테스트")
    public void testUpdateClientBenefit() {
        specialEvent.updateClientBenefit(client, null);
        verify(client).joinEvent();
        verify(client).addBenefitToTotalDiscountAndEventBenefit(SpecialEvent.SPECIAL_EVENT_BENEFIT_VALUE);
    }
}