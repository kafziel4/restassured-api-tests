package ReqRes;

import Clients.ReqResClient;
import Data.Users;
import Models.Users.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class UsersTests {
    private static ReqResClient reqResClient;

    @BeforeAll
    public static void setup() {
        reqResClient = new ReqResClient();
    }

    @Test
    public void getUsers_ShouldReturnStatus200_AndUsersList() {
        // Arrange
        int page = 2;
        UserList expectedResponse = Users.getUserList();

        // Act
        Response response = reqResClient.getUsers(page);

        // Assert
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);

        UserList content = response.as(UserList.class);
        assertEquals(expectedResponse, content);
    }

    @Test
    public void getUserForExistingUser_ShouldReturnStatus200_AndUserData() {
        // Arrange
        SingleUser expectedResponse = new SingleUser(
                new UserData(
                        2,
                        "janet.weaver@reqres.in",
                        "Janet",
                        "Weaver",
                        "https://reqres.in/img/faces/2-image.jpg"
                )
        );

        // Act
        Response response = reqResClient.getSingleUser(expectedResponse.data().id());

        // Assert
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);

        SingleUser content = response.as(SingleUser.class);
        assertEquals(expectedResponse, content);
    }

    @Test
    public void getUserForUserThatDoesNotExist_ShouldReturnStatus404() {
        // Arrange
        int nonexistentId = 23;

        // Act
        Response response = reqResClient.getSingleUser(nonexistentId);

        // Assert
        response
                .then()
                .statusCode(404)
                .contentType(ContentType.JSON);

        SingleUser content = response.as(SingleUser.class);
        assertNull(content.data());
    }

    @Test
    public void postUserWithValidData_ShouldReturnStatus201_AndUserData() {
        // Arrange
        CreateUserRequest requestBody = new CreateUserRequest("morpheus", "leader");
        String oneToThreeDigits = "^\\d{1,3}$";

        // Act
        Response response = reqResClient.postUser(requestBody);

        // Assert
        response
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON);

        CreateUserResponse content = response.as(CreateUserResponse.class);
        assertEquals(requestBody.name(), content.name());
        assertEquals(requestBody.job(), content.job());
        assertTrue(content.id().matches(oneToThreeDigits));
        assertTrue(content.createdAt().isBefore(OffsetDateTime.now()));
    }

    @Test
    public void putUserForExistingUserWithValidData_ShouldReturnStatus200_AndUserData() {
        // Arrange
        int id = 2;
        UpdateUserRequest requestBody = new UpdateUserRequest("morpheus", "zion resident");

        // Act
        Response response = reqResClient.putUser(id, requestBody);

        // Assert
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);

        UpdateUserResponse content = response.as(UpdateUserResponse.class);
        assertEquals(requestBody.name(), content.name());
        assertEquals(requestBody.job(), content.job());
        assertTrue(content.updatedAt().isBefore(OffsetDateTime.now()));
    }

    @Test
    public void patchUserForExistingUserWithValidData_ShouldReturnStatus200_AndUserData() {
        // Arrange
        int id = 2;
        UpdateUserRequest requestBody = new UpdateUserRequest("morpheus", "zion resident");

        // Act
        Response response = reqResClient.patchUser(id, requestBody);

        // Assert
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);

        UpdateUserResponse content = response.as(UpdateUserResponse.class);
        assertEquals(requestBody.name(), content.name());
        assertEquals(requestBody.job(), content.job());
        assertTrue(content.updatedAt().isBefore(OffsetDateTime.now()));
    }

    @Test
    public void deleteUserForExistingUser_ShouldReturnStatus204() {
        // Arrange
        int id = 2;

        // Act
        Response response = reqResClient.deleteUser(id);

        // Assert
        response
                .then()
                .statusCode(204)
                .header("content-length", "0");
    }
}
