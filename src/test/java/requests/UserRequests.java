package requests;

import io.restassured.http.Method;
import models.user.PartialUser;
import models.user.User;
import utilities.BaseRequest;
import utilities.Logs;
import utilities.ResponseManager;

import java.util.Map;

public class UserRequests extends BaseRequest {
    public void getUser(int id) {
        Logs.info("(GET) Get User");

        final var response = getRequest()
                .basePath("users/{id}")
                .pathParam("id", id)
                .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    public void getAllUsers() {
        Logs.info("(GET) Get All User");

        final var response = getRequest()
                .basePath("users")
                .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    public void sortUsers(Map<String, String> queryMap) {
        Logs.info("(GET) Sort User");

        final var response = getRequest()
                .basePath("users")
                .queryParams(queryMap)
                .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    public void filterUsers(Map<String, String> queryMap) {
        Logs.info("(GET) Filter User");

        final var response = getRequest()
                .basePath("users/filter")
                .queryParams(queryMap)
                .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    public void createUsers(User user) {
        Logs.info("(POST) Create User");

        final var response = getRequest()
                .basePath("users/add")
                .body(user)
                .request(Method.POST);

        ResponseManager.setResponse(response);
    }

    public void updateUsers(int id, User user) {
        Logs.info("(PUT) Update User");

        final var response = getRequest()
                .basePath("user/{id}")
                .pathParam("id", id)
                .body(user)
                .request(Method.PUT);

        ResponseManager.setResponse(response);
    }

    public void partialUpdateUsers(int id, PartialUser partialUser) {
        Logs.info("(PATCH) Partial Update User");

        final var response = getRequest()
                .basePath("user/{id}")
                .pathParam("id", id)
                .body(partialUser)
                .request(Method.PATCH);

        ResponseManager.setResponse(response);

    }

    public void deleteUser(int id) {
        Logs.info("(DELETE) Delete User");

        final var response = getRequest()
                .basePath("user/{id}")
                .pathParam("id", id)
                .request(Method.DELETE);

        ResponseManager.setResponse(response);
    }
}
