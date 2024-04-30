package Models.Register;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RegisterResponse(
        @JsonProperty("id") Integer id,
        @JsonProperty("token") String token
) {
}
