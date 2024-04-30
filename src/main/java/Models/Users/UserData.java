package Models.Users;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserData(
        @JsonProperty("id") Integer id,
        @JsonProperty("email") String email,
        @JsonProperty("first_name") String firstName,
        @JsonProperty("last_name") String lastName,
        @JsonProperty("avatar") String avatar
) {
}
