package org.formation.proxibanque.service;

import lombok.RequiredArgsConstructor;
import org.formation.proxibanque.dto.ClientCreateDto;
import org.formation.proxibanque.dto.ClientDto;
import org.formation.proxibanque.dto.ClientUpdateDto;
import org.formation.proxibanque.entity.Card;
import org.formation.proxibanque.entity.Client;
import org.formation.proxibanque.mapper.ClientMapper;
import org.formation.proxibanque.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final CardService cardService;
    private final ClientMapper clientMapper;

    public List<ClientDto> getAllClients() {
        return clientRepository.findAll().stream()
                .map(clientMapper::toDto)
                .toList();
    }

    public Optional<ClientDto> getClientById(Long id) {
        return clientRepository.findById(id)
                .map(clientMapper::toDto);
    }

    public ClientDto createClient(ClientCreateDto dto) {
        Client entity = clientMapper.toEntity(dto);
        Client saved = clientRepository.save(entity);
        return clientMapper.toDto(saved);
    }

    @Transactional
    public Optional<ClientDto> updateClient(Long id, ClientUpdateDto dto) {
        return clientRepository.findById(id).map(client -> {
            clientMapper.updateEntity(client, dto);
            return clientMapper.toDto(client);
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
