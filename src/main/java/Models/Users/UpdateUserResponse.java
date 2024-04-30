package Models.Users;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

public record UpdateUserResponse(
        @JsonProperty("name") String name,
        @JsonProperty("job") String job,
        @JsonProperty("updatedAt") OffsetDateTime updatedAt
) {
}
