package christmas.model.menu;

public enum MenuItem {

    APPETIZER_BUTTON_MUSHROOM_SOUP("애피타이저", "양송이수프", 6000),
    APPETIZER_TAPAS("애피타이저", "타파스", 5500),
    APPETIZER_CAESAR_SALAD("애피타이저", "시저샐러드", 8000),

    MAIN_T_BONE_STEAK("메인", "티본스테이크", 55000),
    MAIN_BBQ_RIB("메인", "바비큐립", 54000),
    MAIN_SEAFOOD_PASTA("메인", "해산물파스타", 35000),
    MAIN_CHRISTMAS_PASTA("메인", "크리스마스파스타", 25000),

    DESSERT_CHOCO_CAKE("디저트", "초코케이크", 15000),
    DESSERT_ICE_CREAM("디저트", "아이스크림", 5000),

    BEVERAGE_ZERO_COLA("음료", "제로콜라", 3000),
    BEVERAGE_RED_WINE("음료", "레드와인", 60000),
    BEVERAGE_CHAMPAGNE("음료", "샴페인", 25000);

    private final String category;
    private final String itemName;
    private final int itemPrice;

    MenuItem(String category, String itemName, int itemPrice) {
        this.category = category;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public static MenuItem getMenuByName(String menuName) {
        for (MenuItem item : values()) {
            if (item.getItemName().equals(menuName)) {
                return item;
            }
        }
        return null;
    }

    public static boolean isNotMenu(String givenName) {
        for (MenuItem item : values()) {
            if (item.getItemName().equals(givenName)) {
                return false;
            }
        }
        return true;
    }

    public String getCategory() {
        return category;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

}
