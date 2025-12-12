package org.vaadin.addons.maplibre.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;
import tools.jackson.databind.json.JsonMapper;

import java.util.HashMap;
import java.util.Map;

@JsonNaming(PropertyNamingStrategies.KebabCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AbstractKebabCasedDto {
    public static ObjectMapper mapper = JsonMapper.builder()
            .addModule(new ColorModule())
            .build();

    private Map<String, Object> supplemental = new HashMap<>();

    /**
     * @return Map of supplemental properties that are not part of the DTO class. These are serialized to the JSON
     * object.
     */
    @JsonAnyGetter
    public Map<String, Object> getSupplemental() {
        if(supplemental == null) {
            supplemental = new HashMap<>();
        }
        return supplemental;
    }

    /**
     * Set supplemental properties from the given JSON string. Can be used to configure some properties that are not
     * (yet) published as a proper API in the DTO class.
     *
     * @param supplementalJson JSON string to set the supplemental properties from
     */
    public void setSupplementalJson(String supplementalJson) {
            JsonNode jsonNode = mapper.readTree(supplementalJson);
            jsonNode.properties().forEach(entry -> {
                supplemental.put(entry.getKey(), entry.getValue());

            });
    }

    // JSON representation to be easily used in JS calls
    @Override
    public String toString() {
        return mapper.writeValueAsString(this);
    }

    protected static String camelToKebabCase(String str) {
        return str.replaceAll("([a-z0-9])([A-Z])", "$1-$2").toLowerCase();
    }
}
