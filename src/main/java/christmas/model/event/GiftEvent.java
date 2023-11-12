package christmas.model.event;

public class GiftEvent {
    public Boolean canGetEvent(Integer givenMoney) {
        return givenMoney >= 120000;
    }

}
