package Models.Users;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

public record CreateUserResponse(
        @JsonProperty("name") String name,
        @JsonProperty("job") String job,
        @JsonProperty("id") String id,
        @JsonProperty("createdAt") OffsetDateTime createdAt
) {
}
