package org.formation.proxibanque.service;

import org.formation.proxibanque.entity.Card;
import org.formation.proxibanque.entity.Client;
import org.formation.proxibanque.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CardService cardService;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> updateClient(Long id, Client clientDetails) {
        return clientRepository.findById(id).map(client -> {
            client.setNom(clientDetails.getNom());
            client.setPrenom(clientDetails.getPrenom());
            client.setAdresse(clientDetails.getAdresse());
            client.setCodePostal(clientDetails.getCodePostal());
            client.setVille(clientDetails.getVille());
            client.setTelephone(clientDetails.getTelephone());
            return clientRepository.save(client);
        });
    }

    @Transactional
    public boolean deleteClient(Long id) {
        Optional<Client> clientOpt = clientRepository.findById(id);
        if (clientOpt.isPresent()) {
            Client client = clientOpt.get();
            if (client.getCards() != null) {
                for (Card card : client.getCards()) {
                    card.setActive(false);
                    cardService.createCard(card);
                }
            }
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
