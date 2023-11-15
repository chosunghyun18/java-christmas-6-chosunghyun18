package christmas.back.application;

import christmas.back.domain.order.MenuOrders;
import christmas.back.domain.user.ClientRepository;
import christmas.back.domain.user.model.Client;
import christmas.back.infrastructure.repository.ClientRepositoryImpl;

public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService() {
        this.clientRepository = new ClientRepositoryImpl();
    }
    public void saveClient(Integer visitDay , MenuOrders menuOrders) {
        Client client = new Client(visitDay,menuOrders);
        client = clientRepository.save(client);
    }
}
