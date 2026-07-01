package requests;

import io.restassured.http.Method;
import models.post.PartialPost;
import models.post.Post;
import utilities.BaseRequest;
import utilities.Logs;
import utilities.ResponseManager;

import java.util.Map;

public class PostRequests extends BaseRequest {

    public void getPost(int id) {
        Logs.info("(GET) Get Single Post");

        final var response = getRequest()
                .basePath("posts/{id}")
                .pathParam("id", id)
                .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    public void getAllPost() {
        Logs.info("(GET) Get All Post");

        final var reponse = getRequest()
                .basePath("posts")
                .request(Method.GET);

        ResponseManager.setResponse(reponse);
    }

    public void sortPosts(Map<String, String> queryMap) {
        Logs.info("(GET) Sort Posts");

        final var response = getRequest()
                .basePath("posts")
                .queryParams(queryMap)
                .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    public void searchPosts(Map<String, String> queryMap) {
        Logs.info("(GET) Search Posts");

        final var response = getRequest()
                .basePath("posts/search")
                .queryParams(queryMap)
                .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    public void createPost(Post post) {
        Logs.info("(POST) Create Posts");

        final var response = getRequest()
                .basePath("posts/add")
                .body(post)
                .request(Method.POST);

        ResponseManager.setResponse(response);
    }

    public void updatePost(int id, Post post) {
        Logs.info("(PUT) Update Posts");

        final var response = getRequest()
                .basePath("posts/{id}")
                .pathParam("id", id)
                .body(post)
                .request(Method.PUT);

        ResponseManager.setResponse(response);
    }

    public void partialUpdatePost(int id, PartialPost partialpost) {
        Logs.info("(PUT) Partial Update Posts");

        final var response = getRequest()
                .basePath("posts/{id}")
                .pathParam("id", id)
                .body(partialpost)
                .request(Method.PATCH);

        ResponseManager.setResponse(response);
    }

    public void deletePost(int id) {
        Logs.info("(DELETE) Delete Post");

        final var response = getRequest()
                .basePath("posts/{id}")
                .pathParam("id", id)
                .request(Method.DELETE);

        ResponseManager.setResponse(response);

    }

}
