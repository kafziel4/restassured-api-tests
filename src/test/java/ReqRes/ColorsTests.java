package ReqRes;

import Clients.ReqResClient;
import Data.Colors;
import Models.Colors.ColorData;
import Models.Colors.ColorList;
import Models.Colors.SingleColor;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ColorsTests {
    private static ReqResClient reqResClient;

    @BeforeAll
    public static void setup() {
        reqResClient = new ReqResClient();
    }

    @Test
    public void getColors_ShouldReturnStatus200_AndColorsList() {
        // Arrange
        ColorList expectedResponse = Colors.getColorList();

        // Act
        Response response = reqResClient.getColors();

        // Assert
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);

        ColorList content = response.as(ColorList.class);
        assertEquals(expectedResponse, content);
    }

    @Test
    public void getColorForExistingColor_ShouldReturnStatus200_AndColorData() {
        // Arrange
        SingleColor expectedResponse = new SingleColor(
                new ColorData(
                        2,
                        "fuchsia rose",
                        2001,
                        "#C74375",
                        "17-2031"
                )
        );

        // Act
        Response response = reqResClient.getSingleColor(expectedResponse.data().id());

        // Assert
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);

        SingleColor content = response.as(SingleColor.class);
        assertEquals(expectedResponse, content);
    }

    @Test
    public void getColorForColorThatDoesNotExist_ShouldReturnStatus404() {
        // Arrange
        int nonexistentId = 23;

        // Act
        Response response = reqResClient.getSingleColor(nonexistentId);

        // Assert
        response
                .then()
                .statusCode(404)
                .contentType(ContentType.JSON);

        SingleColor content = response.as(SingleColor.class);
        assertNull(content.data());
    }
}
