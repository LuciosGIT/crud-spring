package com.joselucio.crud_spring.enums.converters;

import com.joselucio.crud_spring.enums.Category;
import com.joselucio.crud_spring.enums.Status;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, String> {
    @Override
    public String convertToDatabaseColumn(Status status) {
        if (status == null) {
            return null;
        }
        return status.getValue();
    }

    @Override
    public Status convertToEntityAttribute(String c) {
        if(c == null) {
            return null;
        }
        return Stream.of(Status.values())
                .filter(s -> s.getValue().equals(c))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
    }

