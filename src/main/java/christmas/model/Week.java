package christmas.model;

import java.util.List;

public class Week {
    private final List<Integer> days;

    public Week(List<Integer> days) {
        this.days = days;
    }

    public Boolean canGetEvent(Integer day) {
        return days.contains(day);
    }
}
