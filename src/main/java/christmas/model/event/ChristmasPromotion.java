package christmas.model.event;

import christmas.model.User.Client;
import christmas.model.event.discount.DdayEvent;
import christmas.model.event.discount.SpecialEvent;
import christmas.model.event.discount.WeekEvent;
import christmas.model.event.discount.WeekendEvent;
import java.util.List;

public class ChristmasPromotion {
    private final WeekEvent weekEvent;
    private final WeekendEvent weekendEvent;
    private final SpecialEvent specialEvent;
    private final DdayEvent dDayEvent;
    private final GiftEvent giftEvent;

    public ChristmasPromotion() {
        this.dDayEvent = new DdayEvent();
        this.giftEvent = new GiftEvent();
        this.specialEvent = new SpecialEvent(List.of(3, 10, 17, 24, 25, 31));
        this.weekendEvent = new WeekendEvent(List.of(1, 2, 8, 9, 15, 16, 22, 23, 29, 30));
        this.weekEvent = new WeekEvent(
                List.of(3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31));
    }

    public boolean canGetGiftEvent(Client client) {
        if (giftEvent.canGetEvent(client.getTotalAmountBeforeDiscount())) {
            client.setTotalEventAmount(giftEvent.getEventBenefitAmount());
            return true;
        }
        return false;
    }

    public boolean canGetDDayEvent(Client client) {
        return dDayEvent.canGetEvent(client.getVisitDay());
    }

    public Integer getDDayEventBenefit(Client client) {
        return dDayEvent.getEventBenefit(client.getVisitDay());
    }

    public boolean canGetWeekEvent(Client client) {
        if(weekEvent.canGetEvent(client.getVisitDay(),client.getMenuOrders())){
            client.addBenefitToTotalDiscountAmount(weekEvent.getEventBenefit(client.getMenuOrders()));
            return true;
        }
        return false;
    }

    public Integer getWeekEventBenefit(Client client) {
        return weekEvent.getEventBenefit(client.getMenuOrders());
    }

    public boolean canGetWeekendEvent(Client client) {
        if(weekEvent.canGetEvent(client.getVisitDay(),client.getMenuOrders())){
            client.addBenefitToTotalDiscountAmount(weekendEvent.getEventBenefit(client.getMenuOrders()));
            return true;
        }
        return false;
    }

    public Integer getWeekendEventBenefit(Client client) {
        return weekendEvent.getEventBenefit(client.getMenuOrders());
    }

    public boolean canGetSpecialEvent(Client client) {
        if(specialEvent.canGetEvent(client.getVisitDay())){
            client.addBenefitToTotalDiscountAmount(specialEvent.getEventBenefit());
            return true;
        }
        return false;
    }
}
