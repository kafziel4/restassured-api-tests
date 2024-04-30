package Models.Users;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UpdateUserRequest(
        @JsonProperty("name") String name,
        @JsonProperty("job") String job
) {
}
