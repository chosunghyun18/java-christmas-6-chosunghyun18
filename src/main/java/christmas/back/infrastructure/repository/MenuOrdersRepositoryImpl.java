package christmas.back.infrastructure.repository;

import christmas.back.domain.order.MenuOrders;
import christmas.back.domain.order.MenuOrdersRepository;
import christmas.back.infrastructure.db.InMemoryMenuOrdersRepository;

public class MenuOrdersRepositoryImpl implements MenuOrdersRepository {
    @Override
    public MenuOrders save(MenuOrders menuOrders) {
        return InMemoryMenuOrdersRepository.save(menuOrders);
    }

    @Override
    public MenuOrders findById(Long id) {
        return InMemoryMenuOrdersRepository.findById(id).orElseThrow(()->new IllegalArgumentException("[ERROR]"));
    }
}
