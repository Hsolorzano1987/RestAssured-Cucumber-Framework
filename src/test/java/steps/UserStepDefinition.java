package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import models.user.PartialUser;
import models.user.User;
import requests.UserRequests;
import utilities.ResponseManager;

import java.util.Map;

public class UserStepDefinition {
    private final UserRequests userRequests = new UserRequests();
    private Map<String, String> queryParamMap;
    private User user;
    private PartialUser partialUser;


    @When("Se llama al request de obtener todos los Users")
    public void getAllUsers() {
        userRequests.getAllUsers();
    }

    @When("Se llama al request de obtener un User con id {int}")
    public void getUser(int id) {
        userRequests.getUser(id);
    }

    @And("Se hace un schema validation del response body de User")
    public void doSchemaValidation() {
        ResponseManager.doSchemaValidation("src/test/resources/schemas/user.json");
    }

    @When("Se llama al request de eliminar un User con id {int}")
    public void deleteUser(int id) {
        userRequests.deleteUser(id);
    }

    @Given("Se ordena los Users por el valor de {string} de manera {string}")
    public void prepareSort(String key, String value) {
        queryParamMap = Map.of(
                "sortBy", key,
                "order", value
        );
    }

    @When("Se llama al request de ordenar los Users")
    public void sortUsers() {
        userRequests.sortUsers(queryParamMap);
    }

    @Given("Se filtran los Users cuyo {string} sean {string}")
    public void prepareFilter(String key, String value) {
        queryParamMap = Map.of(
                "key", key,
                "value", value
        );
    }

    @When("Se llama al request de filtrar los Users")
    public void filterUsers() {
        userRequests.filterUsers(queryParamMap);
    }

    @Given("Se genera un request body de User")
    public void generateRandomUsers() {
        user = User.generateRandomUser();
    }

    @When("Se llama al request de crear un User")
    public void createUser() {
        userRequests.createUsers(user);
    }

    @When("Se llama al request de actualizar un User con id {int}")
    public void updateUser(int id) {
        userRequests.updateUsers(id, user);
    }

    @Given("Se genera un request body de Partial User")
    public void generateRandomPartialUser() {
        partialUser = PartialUser.generateRandomPartialUser();
    }

    @When("Se llama al request de actualizar parcialmente un User con id {int}")
    public void partialUpdateUser(int id) {
        userRequests.partialUpdateUsers(id, partialUser);
    }
}
