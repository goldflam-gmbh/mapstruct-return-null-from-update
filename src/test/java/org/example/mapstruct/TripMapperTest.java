package org.example.mapstruct;

import org.example.mapstruct.dto.TripDto;
import org.example.mapstruct.mapper.TripMapper;
import org.example.mapstruct.mapper.TripMapperImpl;
import org.example.mapstruct.model.Ship;
import org.example.mapstruct.model.Trip;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class TripMapperTest {
    
    @Autowired
    private TripMapper tripMapper;
    @Test
    void testSetShipToNull() {
        Ship ship = new Ship();
        ship.setName("TestShip");
        ship.setId(1L);
        
        Trip trip = new Trip();
        trip.setName("TestTrip");
        trip.setId(1L);
        trip.setShip(ship);

        TripDto tripDto = new TripDto();
        tripDto.setName("TestTrip");
        tripDto.setId(1L);
        tripDto.setShip(JsonNullable.of(null));
        
        Trip updatedTrip = tripMapper.updateTripWithTripDto(tripDto, trip);
        assertNull(updatedTrip.getShip());
    }
    
    @Test
    void testShipRemainNull() {
        Trip trip = new Trip();
        trip.setName("TestTrip");
        trip.setId(1L);

        TripDto tripDto = new TripDto();
        tripDto.setName("TestTrip");
        tripDto.setId(1L);
        tripDto.setShip(JsonNullable.of(null));

        Trip updatedTrip = tripMapper.updateTripWithTripDto(tripDto, trip);
        //this needs to be null instead of an empty object, or the database will complain because it is transient
        assertNull(updatedTrip.getShip());
    }
}
