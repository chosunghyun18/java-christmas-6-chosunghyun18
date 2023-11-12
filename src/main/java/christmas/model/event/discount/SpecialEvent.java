package christmas.model.event.discount;

import java.util.List;

public class SpecialEvent {
    private final List<Integer> days;

    public SpecialEvent(List<Integer> days) {
        this.days = days;
    }

    public Boolean canGetEvent(Integer day) {
        return days.contains(day);
    }
}
