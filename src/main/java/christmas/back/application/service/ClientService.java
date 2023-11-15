package christmas.back.application.service;

import christmas.back.domain.event.gift.GiftEvent;
import christmas.back.domain.user.ClientRepository;
import christmas.back.domain.user.model.Client;
import christmas.back.infrastructure.repository.ClientRepositoryImpl;

public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService() {
        this.clientRepository = new ClientRepositoryImpl();
    }

    public Client saveClient(Client clientInfo) {
        Client client = new Client(clientInfo);
        return clientRepository.save(client);
    }

    public Client findClientById(Long id) {
        return clientRepository.findById(id);
    }

    public Integer getTotalAmountBeforeDiscount(Long clientId) {
        return findClientById(clientId).getTotalAmountBeforeDiscount();
    }

    public String getGiftEventMenu(Long clientId) {
        return GiftEvent.getGiftMenu(findClientById(clientId));
    }

    public Integer getTotalDiscountAmount(Long clientId) {
        return findClientById(clientId).getTotalDiscountAmount();
    }

    public Integer getAfterDiscount(Long clientId) {
        return findClientById(clientId).getAfterDiscount();
    }

    public String getBadgeContent(Long clientId) {
        return findClientById(clientId).getBadgeContent();
    }

    public void updateBadge(Long clientId) {
        findClientById(clientId).applyBadge();
    }
}
