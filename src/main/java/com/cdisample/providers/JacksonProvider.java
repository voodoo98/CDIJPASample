package com.cdisample.providers;

import javax.enterprise.inject.Produces;

import com.cdisample.annotations.JacksonMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonProvider {

    @Produces
    @JacksonMapper
    public ObjectMapper mapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return mapper;
    }

}
