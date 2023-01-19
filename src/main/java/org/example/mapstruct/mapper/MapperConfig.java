package org.example.mapstruct.mapper;

import org.mapstruct.Condition;
import org.mapstruct.Mapper;
import org.openapitools.jackson.nullable.JsonNullable;


@Mapper(componentModel = "spring")
public abstract class MapperConfig {

    <T> T unwrap(JsonNullable<T> jsonNullable) {
        return jsonNullable.orElse(null);
    }

    <T> JsonNullable<T> wrap(T object) {
        return JsonNullable.of(object);
    }

    @Condition
    <T> boolean isNotEmpty(JsonNullable<T> field) {
        return field != null && field.isPresent();
    }

}
