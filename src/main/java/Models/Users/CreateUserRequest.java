package Models.Users;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateUserRequest(
        @JsonProperty("name") String name,
        @JsonProperty("job") String job
) {
}
