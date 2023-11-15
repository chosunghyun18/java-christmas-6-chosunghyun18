package christmas.back.domain.user.model;

import christmas.back.domain.event.gift.DecemberBadge;
import christmas.back.domain.order.MenuOrders;

public class Client {
    private Long id;
    private Boolean noEvent;
    private Integer visitDay;
    private MenuOrders menuOrders;
    private DecemberBadge badge;
    private Integer totalAmountBeforeDiscount;
    private Integer totalDiscountAmount;
    private Integer totalEventAmount;

    private Client(Long id, Integer visitDay, MenuOrders menuOrders, Integer totalAmountBeforeDiscount, Boolean noEvent,
                   Integer totalDiscountAmount, Integer totalEventAmount, DecemberBadge badge) {
        this.id = id;
        this.visitDay = visitDay;
        this.menuOrders = menuOrders;
        this.totalAmountBeforeDiscount = totalAmountBeforeDiscount;
        this.noEvent = noEvent;
        this.totalDiscountAmount = totalDiscountAmount;
        this.totalEventAmount = totalEventAmount;
        this.badge = badge;
    }

    public Client(Integer visitDay, MenuOrders menuOrders) {
        this(null, visitDay, menuOrders, menuOrders.getTotalAmountBeforeDiscount(), true, 0, 0,DecemberBadge.NONE);
    }
    public Client(Long id , Integer visitDay, MenuOrders menuOrders) {
        this(id, visitDay, menuOrders, menuOrders.getTotalAmountBeforeDiscount(), true, 0, 0,DecemberBadge.NONE);
    }

    public Client(Long id, Client client) {
        this(id, client.visitDay, client.menuOrders, client.totalAmountBeforeDiscount, client.noEvent,
                client.totalDiscountAmount, client.totalEventAmount, client.badge);
    }
    public Long getId(){
        return id;
    }
    public Integer getVisitDay() {
        return visitDay;
    }

    public MenuOrders getMenuOrders() {
        return menuOrders;
    }

    public Integer getTotalAmountBeforeDiscount() {
        return totalAmountBeforeDiscount;
    }

    public Integer getTotalDiscountAmount() {
        return totalDiscountAmount;
    }

    public Integer getAfterDiscount() {
        return totalAmountBeforeDiscount - totalDiscountAmount;
    }

    public String getBadgeContent() {
        return badge.getBadgeContent();
    }

    public void applyBadge() {
        this.badge = badge.updateBadge(totalEventAmount);
    }

    public void joinEvent() {
        this.noEvent = false;
    }

    public void addBenefitToTotalDiscountAmount(Integer eventBenefit) {
        totalDiscountAmount += eventBenefit;
    }

    public void addBenefitToTotalEventAmount(int amount) {
        this.totalEventAmount += amount;
    }

    public boolean isNotJoinEvent() {
        return this.noEvent;
    }
}
