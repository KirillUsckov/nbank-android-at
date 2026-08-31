package framework.helpers;

import org.apache.http.HttpStatus;

import framework.confs.Config;
import framework.enums.ConfigParams;
import framework.models.User;
import framework.models.body.CreateUserRequestBody;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.RequestSpecification;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class ApiHelper {
    @Step("Check api health")
    public static void healthCheck() {
        getBaseAdminRequest()
                .when()
                .get("/api/v1/admin/users")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Step("Send api create user request")
    public static void createUser(CreateUserRequestBody user) {
        getBaseAdminRequest()
                .header("Content-Type", "application/json")
                .when()
                .body(user)
                .post("/api/v1/admin/users")
                .then()
                .statusCode(HttpStatus.SC_CREATED);
    }

    private RequestSpecification getBaseAdminRequest() {
        return RestAssured.given()
                .baseUri(Config.getProperty(ConfigParams.BACKEND_URL))
                .header("accept", "*/*")
                .header("Authorization", "Basic " + Config.getProperty(ConfigParams.ADMIN_TOKEN));
    }
}