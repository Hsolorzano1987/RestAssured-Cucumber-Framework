package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import models.login.LoginResponse;
import org.junit.jupiter.api.Assertions;
import requests.AuthRequests;
import utilities.ResponseManager;

public class AuthStepDefinition {
    private final AuthRequests authRequests = new AuthRequests();
    private String requestBodyPath;
    private LoginResponse loginResponse;

    @Given("Se obtiene el request body de login con credenciales {string}")
    public void getRequestBody(String credentialType) {
        final var commonPath = "src/test/resources/requestsBody/%s.json";
        final var jsonName = switch (credentialType) {
            case "validas" -> "login";
            case "invalidas" -> "invalidCredentials";
            case "vacias" -> "emptyCredentials";
            default -> "";
        };
        requestBodyPath = String.format(commonPath, jsonName);
    }

    @When("Se llama el request del login")
    public void callLoginRequest() {
        authRequests.login(requestBodyPath);
    }

    @And("Se obtiene el response body de login")
    public void getResponseBody() {
        loginResponse = ResponseManager.getResponseBody(LoginResponse.class);
    }

    @And("Se verifica que el id sea positivo")
    public void verifyIdPositive() {
        Assertions.assertTrue(loginResponse.id() > 0);
    }

    @And("Se verifica que el Access Token y Refresh Token tengan una longitud de {int} caracteres")
    public void verifyTokens(int expectedLength) {
        final var accessToken = loginResponse.accesToken();
        final var refreshToken = loginResponse.refreshToken();

        Assertions.assertAll(
                () -> Assertions.assertEquals(accessToken.length(), expectedLength),
                () -> Assertions.assertEquals(refreshToken.length(), expectedLength)
        );
    }
}
