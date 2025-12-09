package org.formation.proxibanque.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ClientCreateDto(
        @NotBlank(message = "Le nom ne peut pas être vide") String nom,

        @NotBlank(message = "Le prénom ne peut pas être vide") String prenom,

        @NotBlank(message = "L'adresse ne peut pas être vide") String adresse,

        @NotBlank(message = "Le code postal ne peut pas être vide") @Pattern(regexp = "\\d{5}", message = "Le code postal doit contenir 5 chiffres") String codePostal,

        @NotBlank(message = "La ville ne peut pas être vide") String ville,

        @Pattern(regexp = "^(\\+33|0)[1-9](\\d{2}){4}$", message = "Le numéro de téléphone n'est pas valide") String telephone) {
}
