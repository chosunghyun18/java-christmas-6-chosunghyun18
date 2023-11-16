package christmas.back.infrastructure.db;

import christmas.back.domain.order.MenuOrders;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryMenuOrdersRepository {
    private static final Map<Long, MenuOrders> database = new HashMap<>();
    public static MenuOrders save(MenuOrders menuOrders) {
        Long usersSize = (long) database.size();
        Long autoIncreaseId = usersSize + 1;
        menuOrders = new MenuOrders(autoIncreaseId,menuOrders);
        database.put(menuOrders.getId(),menuOrders);
        return menuOrders;
    }

    public static Optional<MenuOrders> findById(Long id) {
        return Optional.ofNullable(database.get(id));
    }

    private InMemoryMenuOrdersRepository() {
    }
}
