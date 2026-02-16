package org.vaadin.addons.maplibre.dto;


import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

public class LngLatSerializer extends ValueSerializer<LngLat> {
    @Override
    public void serialize(LngLat value, JsonGenerator gen, SerializationContext ctxt) throws JacksonException {
        gen.writeArray(new double[]{value.lng(), value.lat()},0,2);
    }

}
