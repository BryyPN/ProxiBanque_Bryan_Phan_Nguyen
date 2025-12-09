package org.formation.proxibanque.dto;

import jakarta.validation.constraints.Pattern;

public record ClientUpdateDto(
        String nom,
        String prenom,
        String adresse,

        @Pattern(regexp = "\\d{5}", message = "Le code postal doit contenir 5 chiffres") String codePostal,

        String ville,

        @Pattern(regexp = "^(\\+33|0)[1-9](\\d{2}){4}$", message = "Le numéro de téléphone n'est pas valide") String telephone) {
}
