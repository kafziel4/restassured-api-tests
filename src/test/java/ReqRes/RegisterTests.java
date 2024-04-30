package ReqRes;

import Clients.ReqResClient;
import Models.Common.ErrorResponse;
import Models.Register.RegisterRequest;
import Models.Register.RegisterResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterTests {
    private static ReqResClient reqResClient;

    @BeforeAll
    public static void setup() {
        reqResClient = new ReqResClient();
    }

    @Test
    public void postRegisterWithValidData_ShouldReturnStatus200_AndRegistrationId_AndToken() {
        // Arrange
        RegisterRequest requestBody = new RegisterRequest("eve.holt@reqres.in", "pistol");
        RegisterResponse expectedResponse = new RegisterResponse(4, "QpwL5tke4Pnpja7X4");

        // Act
        Response response = reqResClient.postRegister(requestBody);

        // Assert
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);

        RegisterResponse content = response.as(RegisterResponse.class);
        assertEquals(expectedResponse, content);
    }

    @Test
    public void postRegisterWithMissingPassword_ShouldReturnStatus400_AndValidationError() {
        // Arrange
        RegisterRequest requestBody = new RegisterRequest("sydney@fife", null);
        ErrorResponse expectedResponse = new ErrorResponse("Missing password");

        // Act
        Response response = reqResClient.postRegister(requestBody);

        // Assert
        response
                .then()
                .statusCode(400)
                .contentType(ContentType.JSON);

        ErrorResponse content = response.as(ErrorResponse.class);
        assertEquals(expectedResponse, content);
    }
}
