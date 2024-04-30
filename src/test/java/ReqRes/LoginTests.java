package ReqRes;

import Clients.ReqResClient;
import Models.Common.ErrorResponse;
import Models.Login.LoginRequest;
import Models.Login.LoginResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTests {
    private static ReqResClient reqResClient;

    @BeforeAll
    public static void setup() {
        reqResClient = new ReqResClient();
    }

    @Test
    public void postLoginWithValidData_ShouldReturnStatus200_AndLoginToken() {
        // Arrange
        LoginRequest requestBody = new LoginRequest("eve.holt@reqres.in", "pistol");
        LoginResponse expectedResponse = new LoginResponse("QpwL5tke4Pnpja7X4");

        // Act
        Response response = reqResClient.postLogin(requestBody);

        // Assert
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);

        LoginResponse content = response.as(LoginResponse.class);
        assertEquals(expectedResponse, content);
    }

    @Test
    public void postLoginWithMissingPassword_ShouldReturnStatus400_AndValidationError() {
        // Arrange
        LoginRequest requestBody = new LoginRequest("peter@klaven", null);
        ErrorResponse expectedResponse = new ErrorResponse("Missing password");

        // Act
        Response response = reqResClient.postLogin(requestBody);

        // Assert
        response
                .then()
                .statusCode(400)
                .contentType(ContentType.JSON);

        ErrorResponse content = response.as(ErrorResponse.class);
        assertEquals(expectedResponse, content);
    }
}
