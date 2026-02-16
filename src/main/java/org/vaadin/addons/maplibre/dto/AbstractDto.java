package org.vaadin.addons.maplibre.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import tools.jackson.databind.ObjectMapper;

// TODO figure out if the KebabCaseStrategy is only needed
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AbstractDto {
    static ObjectMapper mapper = new ObjectMapper();

    public static Object[] arr(Object... objects) {
        return objects;
    }

    // JSON representation to be easily used in JS calls
    @Override
    public String toString() {
            return mapper.writeValueAsString(this);
    }
}
