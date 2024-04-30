package Models.Colors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ColorList(
        @JsonProperty("page") Integer page,
        @JsonProperty("per_page") Integer perPage,
        @JsonProperty("total") Integer total,
        @JsonProperty("total_pages") Integer total_pages,
        @JsonProperty("data") List<ColorData> data
) {
}
