package christmas.back.domain.user;

import christmas.back.domain.user.model.Client;

public interface ClientRepository {
    Client save(Client client);
    Client findById(Long id);
}
