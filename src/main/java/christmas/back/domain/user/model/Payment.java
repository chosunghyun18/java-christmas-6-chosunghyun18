package christmas.back.domain.user.model;

public class Payment {
    private final Integer totalPaymentBeforeDiscount;
    private Integer totalDiscountMoney;
    private Integer totalEventBenefitMoney;

    public Payment(Integer totalPaymentBeforeDiscount, Integer totalDiscountMoney, Integer totalEventBenefitMoney) {
        this.totalPaymentBeforeDiscount = totalPaymentBeforeDiscount;
        this.totalDiscountMoney = totalDiscountMoney;
        this.totalEventBenefitMoney = totalEventBenefitMoney;
    }

    public Integer getTotalPaymentBeforeDiscount() {
        return totalPaymentBeforeDiscount;
    }

    public Integer getTotalDiscountMoney() {
        return totalDiscountMoney;
    }

    public Integer getTotalEventBenefitMoney() {
        return totalEventBenefitMoney;
    }

    public Integer getAfterDiscount() {
        return totalPaymentBeforeDiscount - totalDiscountMoney;
    }
    public void addBenefitToTotalDiscountMoney(Integer eventBenefit) {
        this.totalDiscountMoney += eventBenefit;
    }

    public void addBenefitToTotalEventAmount(Integer moneyBenefit) {
        this.totalEventBenefitMoney += moneyBenefit;
    }

    public void addBenefitToTotalDiscountAndEventBenefit(int benefit) {
        addBenefitToTotalDiscountMoney(benefit);
        addBenefitToTotalEventAmount(benefit);
    }

    public boolean checkCanGetEvent(int minMoneyValue) {
        return totalPaymentBeforeDiscount >= minMoneyValue;
    }
}
