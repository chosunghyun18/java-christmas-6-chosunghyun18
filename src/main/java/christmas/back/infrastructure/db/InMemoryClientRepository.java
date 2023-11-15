package christmas.back.infrastructure.db;

import christmas.back.domain.menu.MenuItem;
import christmas.back.domain.order.MenuOrders;
import christmas.back.domain.user.model.Client;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryClientRepository {
    private static final Map<Long, Client> database = new HashMap<>();
    static {
        final Map<MenuItem, Integer> initOrders = new HashMap<>();
        final Client client = new Client(1L,1,new MenuOrders(initOrders));
        database.put(client.getId(),client);
    }
    public static void save(Client client) {
        Long usersSize = (long)database.size();
        Long autoIncreaseId = usersSize + 1;
        client = new Client(autoIncreaseId,client);
        database.put(client.getId(),client);
    }

    public static Optional<Client> findById(Long id) {
        return Optional.ofNullable(database.get(id));
    }

    private InMemoryClientRepository() {}
}
