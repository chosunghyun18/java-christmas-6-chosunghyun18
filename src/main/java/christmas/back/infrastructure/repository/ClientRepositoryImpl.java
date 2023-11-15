package christmas.back.infrastructure.repository;

import christmas.back.domain.user.ClientRepository;
import christmas.back.domain.user.model.Client;
import christmas.back.infrastructure.db.InMemoryClientRepository;

public class ClientRepositoryImpl implements ClientRepository {
    @Override
    public Client save(Client client) {
        InMemoryClientRepository.save(client);
        return null;
    }

    @Override
    public Client findById(Long id) {
        return InMemoryClientRepository.findById(id).orElseThrow(()->new IllegalArgumentException("[ERROR]"));
    }
}
