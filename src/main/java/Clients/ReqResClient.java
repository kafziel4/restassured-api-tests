package Clients;

import Models.Login.LoginRequest;
import Models.Register.RegisterRequest;
import Models.Users.CreateUserRequest;
import Models.Users.UpdateUserRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ReqResClient {
    private static final String USERS_PATH = "/users";
    private static final String COLORS_PATH = "/colors";
    private static final String REGISTER_PATH = "/register";
    private static final String LOGIN_PATH = "/login";

    public ReqResClient() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    public Response getUsers(int page) {
        return given()
                .queryParam("page", page)
                .get(USERS_PATH);
    }

    public Response getSingleUser(int id) {
        return given()
                .pathParams("id", id)
                .get(USERS_PATH + "/{id}");
    }

    public Response postUser(CreateUserRequest requestBody) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(USERS_PATH);
    }

    public Response putUser(int id, UpdateUserRequest requestBody) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .pathParams("id", id)
                .put(USERS_PATH + "/{id}", id);
    }

    public Response patchUser(int id, UpdateUserRequest requestBody) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .pathParams("id", id)
                .patch(USERS_PATH + "/{id}");
    }

    public Response deleteUser(int id) {
        return given()
                .pathParams("id", id)
                .delete(USERS_PATH + "/{id}");
    }

    public Response getColors() {
        return given()
                .get(COLORS_PATH);
    }

    public Response getSingleColor(int id) {
        return given()
                .pathParams("id", id)
                .get(COLORS_PATH + "/{id}");
    }

    public Response postRegister(RegisterRequest requestBody) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(REGISTER_PATH);
    }

    public Response postLogin(LoginRequest requestBody) {
        return given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(LOGIN_PATH);
    }
}
