package com.elasri.aftas.config;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeDeserializer extends JsonDeserializer<LocalTime> {
    @Override
    public LocalTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        String timeString = p.getValueAsString();
        try {
            return LocalTime.parse(timeString, DateTimeFormatter.ofPattern("HH:mm:ss"));
        } catch (Exception e) {
            // Handle the exception, log an error, or return a default value
            throw new IOException("Error deserializing LocalTime: " + e.getMessage(), e);
        }
    }
}
