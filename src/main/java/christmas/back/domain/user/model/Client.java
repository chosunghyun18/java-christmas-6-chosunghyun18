package christmas.back.domain.user.model;

import christmas.back.domain.event.gift.DecemberBadge;
import christmas.back.domain.order.MenuOrders;

public class Client {
    private final Long id;
    private final Long menuOrdersId;
    private Boolean noEvent;
    private final Integer visitDay;
    private DecemberBadge badge;
    private Payment payment;

    public Client(Long id, Long menuOrdersId, Boolean noEvent, Integer visitDay, DecemberBadge badge,
                  Integer totalAmountBeforeDiscount, Integer totalDiscountAmount, Integer totalEventAmount) {
        this.id = id;
        this.menuOrdersId = menuOrdersId;
        this.noEvent = noEvent;
        this.visitDay = visitDay;
        this.badge = badge;
        this.payment = new Payment(totalAmountBeforeDiscount, totalDiscountAmount, totalEventAmount);
    }

    public Client(Integer visitDay, MenuOrders menuOrders) {
        this(null, menuOrders.getId(), true, visitDay, DecemberBadge.NONE, menuOrders.getTotalAmountBeforeDiscount(), 0,
                0);
    }

    public Client(Client client) {
        this(null, client.menuOrdersId, client.noEvent, client.getVisitDay(), client.badge,
                client.payment.getTotalPaymentBeforeDiscount(), client.payment.getTotalDiscountMoney(),
                client.payment.getTotalEventBenefitMoney());
    }

    public Client(Long id, Client client) {
        this(id, client.menuOrdersId, client.noEvent, client.getVisitDay(), client.badge,
                client.payment.getTotalPaymentBeforeDiscount(), client.payment.getTotalDiscountMoney(),
                client.payment.getTotalEventBenefitMoney());
    }

    public Long getId() {
        return id;
    }

    public Integer getVisitDay() {
        return visitDay;
    }

    public String getBadgeContent() {
        return badge.getBadgeContent();
    }

    public void applyBadge() {
        this.badge = badge.updateBadge(payment.getTotalEventBenefitMoney());
    }

    public void joinEvent() {
        this.noEvent = false;
    }

    public Long getMenuOrdersId() {
        return menuOrdersId;
    }

    public void addBenefitToTotalDiscountAndEventBenefit(int benefit) {
        payment.addBenefitToTotalDiscountAndEventBenefit(benefit);
    }

    public void addBenefitToTotalEventAmount(int benefit) {
        payment.addBenefitToTotalEventAmount(benefit);
    }

    public Boolean checkCanGetEvent(int minMoneyValue) {
        return payment.checkCanGetEvent(minMoneyValue);
    }

    public Boolean canGetEventByCheckDDay(Integer dDayBaseDay) {
        boolean re  = visitDay <= dDayBaseDay;
        return  re;
    }

    public Payment getPayment() {
        return payment;
    }
}
