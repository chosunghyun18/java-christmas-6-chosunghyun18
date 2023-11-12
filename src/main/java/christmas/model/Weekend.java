package christmas.model;

import java.util.List;

public class Weekend {
    public Weekend(List<Integer> days) {
        this.days = days;
    }

    private final List<Integer> days;

    public Boolean canGetEvent(Integer day) {
        return days.contains(day);
    }
}
