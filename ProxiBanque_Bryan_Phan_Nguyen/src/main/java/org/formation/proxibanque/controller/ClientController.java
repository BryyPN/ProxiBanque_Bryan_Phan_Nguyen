package org.formation.proxibanque.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.formation.proxibanque.dto.ClientCreateDto;
import org.formation.proxibanque.dto.ClientDto;
import org.formation.proxibanque.dto.ClientUpdateDto;
import org.formation.proxibanque.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public List<ClientDto> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable Long id) {
        return clientService.getClientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ClientDto createClient(@RequestBody @Valid ClientCreateDto dto) {
        return clientService.createClient(dto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ClientDto> updateClient(@PathVariable Long id, @RequestBody @Valid ClientUpdateDto dto) {
        return clientService.updateClient(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        if (clientService.deleteClient(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
