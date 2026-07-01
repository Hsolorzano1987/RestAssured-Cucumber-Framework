package requests;

import io.restassured.http.Method;
import utilities.BaseRequest;
import utilities.Logs;
import utilities.ResponseManager;

import java.io.File;

public class AuthRequests extends BaseRequest {
    public void login(String filepath) {
        Logs.info("(POST) Login Request");

        final var response = getRequest()
                .basePath("login")
                .body(new File(filepath))
                .request(Method.POST);

        ResponseManager.setResponse(response);

    }
}
