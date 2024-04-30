package Models.Colors;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ColorData(
        @JsonProperty("id") Integer id,
        @JsonProperty("name") String name,
        @JsonProperty("year") Integer year,
        @JsonProperty("color") String color,
        @JsonProperty("pantone_value") String pantoneValue
) {
}
