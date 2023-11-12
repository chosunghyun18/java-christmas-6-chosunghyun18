package christmas.model.User;

import christmas.model.order.MenuOrders;

public class Client {
    private Integer visitDay;
    private MenuOrders menuOrders;
    private Integer totalAmountBeforeDiscount;
    private Boolean noEvent;
    private Integer totalDiscountAmount;
    private Integer totalEventAmount;

    public Client(Integer visitDay, MenuOrders menuOrders) {
        this.visitDay = visitDay;
        this.menuOrders = menuOrders;
        this.totalAmountBeforeDiscount = menuOrders.getTotalAmountBeforeDiscount();
        this.noEvent = true;
        this.totalDiscountAmount = 0;
        this.totalEventAmount = 0;
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

    public void setTotalEventAmount(Integer totalEventAmount) {
        this.totalEventAmount = totalEventAmount+totalDiscountAmount;
    }

    public Boolean getNoEvent() {
        return noEvent;
    }

    public Integer getTotalDiscountAmount() {
        return totalDiscountAmount;
    }

    public Integer getTotalEventAmount() {
        return totalEventAmount;
    }

    public Integer getAfterDiscount() {
        return totalAmountBeforeDiscount-totalDiscountAmount;
    }

    public void setNoEvent(Boolean noEvent) {
        this.noEvent = noEvent;
    }

    public String getBadge() {
        if (totalEventAmount >= 20000) {
            return "산타";
        }
        if (totalEventAmount >= 10000) {
            return "트리";
        }
        if (totalEventAmount >= 5000) {
            return "별";
        }
        return "없음";
    }

    public void addBenefitToTotalDiscountAmount(Integer eventBenefit) {
        totalDiscountAmount+=eventBenefit;
    }
}
