package christmas.model.event.discount;

public class DdayEvent {
    private final Integer day = 25;
    public Boolean canGetEvent(Integer givenDay) {
        return givenDay <= day ;
    }
    public Integer getEventBenefit(Integer givenDay){
        return 1000 + (givenDay-1)*100;
    }
}
