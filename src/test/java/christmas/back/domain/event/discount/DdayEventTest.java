package christmas.back.domain.event.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import christmas.back.domain.event.config.EventType;
import christmas.back.domain.user.model.Client;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DdayEventTest {
    private DdayEvent ddayEvent;
    private Client client;

    @BeforeEach
    public void setUp() {
        ddayEvent = new DdayEvent();
        client = mock(Client.class);
    }

    @Test
    @DisplayName("이벤트 받을 수 있는지 확인")
    public void testCanGetEvent() {
        when(client.canGetEventByCheckDDay(25)).thenReturn(true);
        boolean canGetEvent = ddayEvent.canGetEvent(client, null);
        assertTrue(canGetEvent);
    }

    @Test
    @DisplayName("이벤트 혜택 확인")
    public void testGetEventBenefit() {
        DdayEvent ddayEvent = new DdayEvent();
        Client client = mock(Client.class);
        when(client.getVisitDay()).thenReturn(20);
        Map<EventType, Integer> eventBenefit = ddayEvent.getEventBenefit(client, null);
        assertEquals(2900, eventBenefit.get(EventType.DDayEvent).intValue());
    }

}