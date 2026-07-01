package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.RequestManager;
import utilities.ResponseManager;

public class CommonsStepDefinition {
    private final RequestManager requestManager = new RequestManager();

    @Then("Se verifica que el status code sea {int}")
    public void verifyStatusCode(int expectedStatusCode) {
        ResponseManager.verifyStatusCode(expectedStatusCode);
    }

    @And("Se verifica que el response time sea menor a {int} ms")
    public void verifyResponseTime(int maxResponseTime) {
        ResponseManager.verifyResponseTime(maxResponseTime);
    }

    @Given("el ususario se autentica con el servidor")
    public void initAuth() {
        requestManager.initAuth();
    }
}
