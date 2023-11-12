package christmas.model.User;

import christmas.model.order.MenuOrders;

public class Client {
    private Integer visitDay;
    private MenuOrders menuOrders;
    private Integer totalAmountBeforeDiscount;
    private Boolean noEvent;
    private Integer totalDiscountAmount;
    private Integer totalEventAmount;
    private String badge;

    public Client(Integer visitDay, MenuOrders menuOrders) {
        this.visitDay = visitDay;
        this.menuOrders = menuOrders;
        this.totalAmountBeforeDiscount = menuOrders.getTotalAmountBeforeDiscount();
        this.noEvent = true;
        this.totalDiscountAmount = 0;
        this.totalEventAmount = 0;
        this.badge = "없음";
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
        return totalAmountBeforeDiscount-totalDiscountAmount;
    }
    public String getBadge() {
        return badge;
    }
    public void applyBadge() {
        if (this.totalEventAmount >= 20000) {
            badge = "산타";
            return;
        }
        if (this.totalEventAmount >= 10000) {
            badge ="트리";
            return;
        }
        if (this.totalEventAmount >= 5000) {
            badge ="별";
        }
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
