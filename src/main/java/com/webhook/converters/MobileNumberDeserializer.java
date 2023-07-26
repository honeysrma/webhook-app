package com.webhook.converters;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class MobileNumberDeserializer extends JsonDeserializer<String> {

    @Override
    public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String originalValue = p.getText();

        // Check if the first character is '0', and if so, remove it
        if (originalValue != null && originalValue.startsWith("0")) {
            return originalValue.substring(1);
        }

        return originalValue;
    }
}
