package utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import requests.AuthRequests;

public class RequestManager {
    public void initRequest() {
        Logs.debug("Creando el request");
        final var request = RestAssured.given().spec(buildRequestSpec());
        Logs.debug("Guardando el request en el request provider");
        new RequestProvider().set(request);
    }

    public RequestSpecification buildRequestSpec() {
        return new RequestSpecBuilder()
                .addFilter(new RequestFilter()) //filter
                .setBaseUri("https://dummyjson.com/auth")// base url
                .setContentType(ContentType.JSON) //request content tipe
                .build();
    }

    public void initAuth() {
        Logs.info("Autenticandose con el request login");
        final var authRequests = new AuthRequests();
        authRequests.login("src/test/resources/requestsBody/login.json");
        final var token = ResponseManager.getPathAsString("accessToken");

        new RequestProvider().get().auth().preemptive().oauth2(token);

    }
}
