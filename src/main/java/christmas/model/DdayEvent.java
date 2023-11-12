package christmas.model;

import java.util.List;

public class DdayEvent {
    private final Integer day = 25;
    public Boolean canGetEvent(Integer givenDay) {
        return givenDay <= day ;
    }

}
