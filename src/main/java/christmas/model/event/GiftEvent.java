package christmas.model.event;

public class GiftEvent {
    public Boolean canGetEvent(Integer givenMoney) {
        return givenMoney >= 120000;
    }

    public Integer getEventBenefit() {
        return 25000;
    }
}
