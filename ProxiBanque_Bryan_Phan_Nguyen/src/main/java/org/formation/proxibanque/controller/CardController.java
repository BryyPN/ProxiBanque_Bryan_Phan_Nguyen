package org.formation.proxibanque.controller;

import org.formation.proxibanque.entity.Card;
import org.formation.proxibanque.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/{id}")
    public Optional<Card> getCardById(@PathVariable Long id) {
        return cardService.getCardById(id);
    }

    @PostMapping
    public Card createCard(@RequestBody Card card) {
        return cardService.createCard(card);
    }

    @DeleteMapping("/{id}")
    public void deleteCard(@PathVariable Long id) {
        cardService.deleteCard(id);
    }
}
