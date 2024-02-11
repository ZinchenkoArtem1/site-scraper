package ua.zinchenko.sitescraper.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.spi.json.JacksonJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

public class JsonPathConfig {

    private JsonPathConfig() {}

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private static final Configuration CONFIGURATION = Configuration.builder()
            .jsonProvider(new JacksonJsonProvider(OBJECT_MAPPER))
            .mappingProvider(new JacksonMappingProvider(OBJECT_MAPPER))
            .build();

    public static Configuration getConfiguration() {
        return CONFIGURATION;
    }
}
