package utilities;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.io.File;

public class ResponseManager {
    private static Response response;

    public static void verifyStatusCode(int expectedStatusCode) {
        Logs.info("Verificando el status code");
        Assertions.assertEquals(response.getStatusCode(), expectedStatusCode);
    }

    public static void verifyResponseTime(int maxResponseTime) {
        Logs.info("Verificando el response time");
        Assertions.assertTrue(response.getTime() < maxResponseTime);
    }

    public static void doSchemaValidation(String schemaPath) {
        Logs.info("Haciendo el Schema validation");
        response
                .then()
                .body(JsonSchemaValidator.matchesJsonSchema(new File(schemaPath)));
    }

    public static <T> T getResponseBody(Class<T> clazz) {
        return response.body().as(clazz);
    }

    public static String getPathAsString(String path) {
        return response.path(path).toString();
    }

    public static void setResponse(Response response) {
        ResponseManager.response = response;
    }

}
