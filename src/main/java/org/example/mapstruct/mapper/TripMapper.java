package org.example.mapstruct.mapper;

import org.example.mapstruct.model.Trip;
import org.mapstruct.*;
import org.example.mapstruct.dto.TripDto;


@Mapper(componentModel = "spring", uses = {MapperConfig.class, ShipMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class TripMapper {

    public abstract TripDto tripToTripDto(Trip trip);

    public abstract Trip tripDtoToTrip(TripDto tripDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    public abstract Trip updateTripWithTripDto(TripDto update, @MappingTarget Trip destination);

}
