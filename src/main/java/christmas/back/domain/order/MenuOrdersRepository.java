package christmas.back.domain.order;

public interface MenuOrdersRepository {
    MenuOrders save(MenuOrders order);
    MenuOrders findById(Long id);
}
