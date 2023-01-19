package org.example.mapstruct.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.openapitools.jackson.nullable.JsonNullable;


public class TripDto {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("ship")
    private JsonNullable<ShipDto> ship = JsonNullable.undefined();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JsonNullable<ShipDto> getShip() {
        return ship;
    }

    public void setShip(JsonNullable<ShipDto> ship) {
        this.ship = ship;
    }

}
