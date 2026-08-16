package helpers;

import org.apache.http.HttpStatus;

import confs.Config;
import enums.ConfigParams;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ApiHelper {
    @Step("Check api health")
    public static void healthCheck() {
        var backUrl = Config.getProperty(ConfigParams.BACKEND_URL);
        var admin = Config.getProperty(ConfigParams.ADMIN_TOKEN);

        RestAssured.given()
                .baseUri(backUrl)
                .header("accept", "*/*")
                .header("Authorization", "Basic " + admin)
                .when()
                .get("/api/v1/admin/users")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}