package Models.Login;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LoginResponse(@JsonProperty("token") String token) {
}
