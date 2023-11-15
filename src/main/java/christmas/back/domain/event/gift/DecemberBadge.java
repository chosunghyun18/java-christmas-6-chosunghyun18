package christmas.back.domain.event.gift;

public enum DecemberBadge {
    NONE("없음"),
    STAR("별"),
    TREE("트리"),
    SANTA("산타");

    private final String name;

    DecemberBadge(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public static DecemberBadge updateBadge(Integer totalEventAmount) {
        if (totalEventAmount >= 20000) {
            return SANTA;
        }
        if (totalEventAmount >= 10000) {
            return TREE;
        }
        if (totalEventAmount >= 5000) {
            return STAR;
        }
        return NONE;
    }

    public String getBadgeContent() {
        return getName();
    }
}
