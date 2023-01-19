package org.example.mapstruct.mapper;

import org.example.mapstruct.dto.ShipDto;
import org.example.mapstruct.model.Ship;
import org.mapstruct.*;


@Mapper(componentModel = "spring", uses = {MapperConfig.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class ShipMapper {

    public abstract ShipDto shipToShipDto(Ship ship);

    public abstract Ship shipDtoToShip(ShipDto shipDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
    @Mapping(target = "id", ignore = true)
    public abstract Ship updateShipWithShipDto(ShipDto update, @MappingTarget Ship destination);
}
