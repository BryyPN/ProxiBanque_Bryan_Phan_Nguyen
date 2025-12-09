package org.formation.proxibanque.mapper;

import org.formation.proxibanque.dto.ClientCreateDto;
import org.formation.proxibanque.dto.ClientDto;
import org.formation.proxibanque.dto.ClientUpdateDto;
import org.formation.proxibanque.entity.Client;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {

    ClientDto toDto(Client client);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "accounts", ignore = true)
    @Mapping(target = "cards", ignore = true)
    Client toEntity(ClientCreateDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "accounts", ignore = true)
    @Mapping(target = "cards", ignore = true)
    void updateEntity(@MappingTarget Client entity, ClientUpdateDto dto);
}
