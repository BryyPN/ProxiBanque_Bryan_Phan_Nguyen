package org.formation.proxibanque.mapper;

import javax.annotation.processing.Generated;
import org.formation.proxibanque.dto.ClientCreateDto;
import org.formation.proxibanque.dto.ClientDto;
import org.formation.proxibanque.dto.ClientUpdateDto;
import org.formation.proxibanque.entity.Client;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-09T11:15:30+0100",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251118-1623, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDto toDto(Client client) {
        if ( client == null ) {
            return null;
        }

        Long id = null;
        String nom = null;
        String prenom = null;
        String adresse = null;
        String codePostal = null;
        String ville = null;
        String telephone = null;

        id = client.getId();
        nom = client.getNom();
        prenom = client.getPrenom();
        adresse = client.getAdresse();
        codePostal = client.getCodePostal();
        ville = client.getVille();
        telephone = client.getTelephone();

        ClientDto clientDto = new ClientDto( id, nom, prenom, adresse, codePostal, ville, telephone );

        return clientDto;
    }

    @Override
    public Client toEntity(ClientCreateDto dto) {
        if ( dto == null ) {
            return null;
        }

        Client client = new Client();

        client.setNom( dto.nom() );
        client.setPrenom( dto.prenom() );
        client.setAdresse( dto.adresse() );
        client.setCodePostal( dto.codePostal() );
        client.setVille( dto.ville() );
        client.setTelephone( dto.telephone() );

        return client;
    }

    @Override
    public void updateEntity(Client entity, ClientUpdateDto dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.nom() != null ) {
            entity.setNom( dto.nom() );
        }
        if ( dto.prenom() != null ) {
            entity.setPrenom( dto.prenom() );
        }
        if ( dto.adresse() != null ) {
            entity.setAdresse( dto.adresse() );
        }
        if ( dto.codePostal() != null ) {
            entity.setCodePostal( dto.codePostal() );
        }
        if ( dto.ville() != null ) {
            entity.setVille( dto.ville() );
        }
        if ( dto.telephone() != null ) {
            entity.setTelephone( dto.telephone() );
        }
    }
}
