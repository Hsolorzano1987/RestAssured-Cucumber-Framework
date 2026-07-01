package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import models.post.PartialPost;
import models.post.Post;
import models.post.PostResponse;
import org.junit.jupiter.api.Assertions;
import requests.PostRequests;
import utilities.ResponseManager;

import java.util.Map;

public class PostStepDefinition {
    private final PostRequests postsRequests = new PostRequests();
    private Map<String, String> queryParamMap;
    private Post post;
    private PartialPost partialPost;
    private PostResponse postResponse;

    @When("Se llama al request de obtener todos los posts")
    public void getAllPosts() {
        postsRequests.getAllPost();
    }

    @When("Se llama al request de obtener un Post con id {int}")
    public void getPost(int id) {
        postsRequests.getPost(id);
    }

    @And("Se hace un schema validation del response body de Post")
    public void doSchemaValidation() {
        ResponseManager.doSchemaValidation("src/test/resources/schemas/post.json");
    }

    @When("Se llama al request de eliminar un Post con id {int}")
    public void deletePost(int id) {
        postsRequests.deletePost(id);
    }

    @Given("Se ordena por el valor de {string} de manera {string}")
    public void prepareSort(String key, String value) {
        queryParamMap = Map.of(
                "sortBy", key,
                "order", value
        );
    }

    @When("Se llama al request de ordenar los Posts")
    public void sortPosts() {
        postsRequests.sortPosts(queryParamMap);
    }

    @Given("Se busca el Post que contenga {string}")
    public void prepareSearch(String query) {
        queryParamMap = Map.of("q", query);
    }

    @When("Se llama al request de buscar un Post")
    public void searchPost() {
        postsRequests.searchPosts(queryParamMap);
    }

    @Given("Se genera un request body de Post")
    public void generateRandomPost() {
        post = Post.generateRandomPost();
    }

    @When("Se llama al request de crear un Post")
    public void createPost() {
        postsRequests.createPost(post);
    }

    @When("Se llama al request de actualizar un Post con id {int}")
    public void updatePost(int id) {
        postsRequests.updatePost(id, post);
    }

    @Given("Se genera un request body de Partial Post")
    public void generateRandomPartialPost() {
        partialPost = PartialPost.generateRandomPartialPost();
    }

    @When("Se llama al request de actualizar parcialmente un Post con id {int}")
    public void partialUpdatePost(int id) {
        postsRequests.partialUpdatePost(id, partialPost);
    }

    @And("Se obtiene el response body de Post")
    public void getResponseBody() {
        postResponse = ResponseManager.getResponseBody(PostResponse.class);
    }

    @And("Se verifica el {int}, {string}, {int}, {int} & {int} sean correctos")
    public void verifyPostData(int id, String title, int likes, int dislikes, int views) {
        Assertions.assertAll(
                () -> Assertions.assertEquals(postResponse.id(), id),
                () -> Assertions.assertEquals(postResponse.title(), title),
                () -> Assertions.assertEquals(postResponse.reactions().likes(), likes),
                () -> Assertions.assertEquals(postResponse.reactions().dislikes(), dislikes),
                () -> Assertions.assertEquals(postResponse.views(), views)
        );
    }
}

