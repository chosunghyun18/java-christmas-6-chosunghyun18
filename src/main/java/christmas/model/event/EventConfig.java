package christmas.model.event;

import christmas.model.event.discount.DdayEvent;
import christmas.model.event.discount.SpecialEvent;
import christmas.model.event.discount.WeekEvent;
import christmas.model.event.discount.WeekendEvent;
import java.util.ArrayList;
import java.util.List;

public class EventConfig {
    public static List<BaseEvent> configEvent() {
        List<BaseEvent> arr = new ArrayList<>();
        arr.add(new DdayEvent());
        arr.add(new SpecialEvent(List.of(3, 10, 17, 24, 25, 31)));
        arr.add(new WeekendEvent(List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30)));
        arr.add(new WeekEvent(List.of(3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31)));
        arr.add(new GiftEvent());
        return arr;
    }
}
