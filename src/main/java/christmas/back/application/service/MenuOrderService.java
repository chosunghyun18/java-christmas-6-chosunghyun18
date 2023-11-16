package christmas.back.application.service;

import christmas.back.domain.order.MenuOrders;
import christmas.back.domain.order.MenuOrdersRepository;
import christmas.back.infrastructure.repository.MenuOrdersRepositoryImpl;

public class MenuOrderService {
    private final MenuOrdersRepository menuOrdersRepository;

    public MenuOrderService() {
        this.menuOrdersRepository = new MenuOrdersRepositoryImpl();
    }

    public MenuOrders saveOrders(MenuOrders menuOrders) {
        return menuOrdersRepository.save(menuOrders);
    }

    public MenuOrders findMenuOrdersById(Long menuOrdersId) {
        return menuOrdersRepository.findById(menuOrdersId);
    }
}
