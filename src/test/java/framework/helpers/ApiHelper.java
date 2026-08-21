package framework.helpers;

import org.apache.http.HttpStatus;

import framework.confs.Config;
import framework.enums.ConfigParams;
import framework.models.User;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class ApiHelper {
    @Step("Check api health")
    public static void healthCheck() {
        RestAssured.given()
                .baseUri(Config.getProperty(ConfigParams.BACKEND_URL))
                .header("accept", "*/*")
                .header("Authorization", "Basic " + Config.getProperty(ConfigParams.ADMIN_TOKEN))
                .when()
                .get("/api/v1/admin/users")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Step("Send api create user request")
    public static void createUser(User user) {
        RestAssured.given()
                .baseUri(Config.getProperty(ConfigParams.BACKEND_URL))
                .header("accept", "*/*")
                .header("Authorization", "Basic " + Config.getProperty(ConfigParams.ADMIN_TOKEN))
                .when()
                .body(user)
                .post("/api/v1/admin/users")
                .then()
                .statusCode(HttpStatus.SC_CREATED);
    }
}