package christmas.back.domain.user.model;

import christmas.back.domain.event.gift.DecemberBadge;
import christmas.back.domain.order.MenuOrders;

public class Client {
    private final Long id;
    private final Long menuOrdersId;
    private Boolean noEvent;
    private final Integer visitDay;
    private DecemberBadge badge;
    private final Integer totalAmountBeforeDiscount;
    private Integer totalDiscountAmount;
    private Integer totalEventAmount;

    private Client(Long id, Long menuOrdersId, Boolean noEvent, Integer visitDay, DecemberBadge badge,
                  Integer totalAmountBeforeDiscount, Integer totalDiscountAmount, Integer totalEventAmount) {
        this.id = id;
        this.menuOrdersId = menuOrdersId;
        this.noEvent = noEvent;
        this.visitDay = visitDay;
        this.badge = badge;
        this.totalAmountBeforeDiscount = totalAmountBeforeDiscount;
        this.totalDiscountAmount = totalDiscountAmount;
        this.totalEventAmount = totalEventAmount;
    }

    public Client(Integer visitDay, MenuOrders menuOrders) {
        this(null, menuOrders.getId(),true,visitDay,DecemberBadge.NONE,menuOrders.getTotalAmountBeforeDiscount(), 0, 0);
    }
    public Client(Client client) {
        this(null,client.menuOrdersId,client.noEvent,client.getVisitDay(),client.badge,client.totalAmountBeforeDiscount,client.totalDiscountAmount,client.totalEventAmount);
    }
    public Client(Long id,Client client){
        this(id, client.menuOrdersId,client.noEvent,client.getVisitDay(),client.badge,client.totalAmountBeforeDiscount,client.totalDiscountAmount,client.totalEventAmount);
    }
    public Long getId(){
        return id;
    }
    public Integer getVisitDay() {
        return visitDay;
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

    public Long getMenuOrdersId() {
        return menuOrdersId;
    }
}
