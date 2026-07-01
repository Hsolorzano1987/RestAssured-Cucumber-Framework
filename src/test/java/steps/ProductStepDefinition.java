package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import models.product.PartialProduct;
import models.product.Product;
import requests.ProductsRequests;
import utilities.ResponseManager;

import java.util.Map;

public class ProductStepDefinition {
    private final ProductsRequests productsRequests = new ProductsRequests();
    private Map<String, String> queryParamMap;
    private Product product;
    private PartialProduct partialProduct;

    @When("Se llama al request de obtener todos los Products")
    public void getAllProducts() {
        productsRequests.getAllProducts();
    }

    @When("Se llama al request de obtener un Product con is {int}")
    public void getProduct(int id) {
        productsRequests.getProduct(id);
    }

    @And("Se hace un schema validation del response body de Product")
    public void doSchemaValidation() {
        ResponseManager.doSchemaValidation("src/test/resources/schemas/product.json");
    }

    @When("Se llama al request de eliminar un Product con id {int}")
    public void deleteProduct(int id) {
        productsRequests.deleteProduct(id);
    }

    @Given("Se ordena lo Products por el valor de {string} de manera {string}")
    public void prepareSortProducts(String key, String value) {
        queryParamMap = Map.of(
                "sortBy", key,
                "order", value
        );
    }

    @When("Se llama al request de ordenar los Products")
    public void sortProducts() {
        productsRequests.sortProducts(queryParamMap);
    }

    @Given("Se busca el Product que contenga {string}")
    public void prepareSearchProducts(String query) {
        queryParamMap = Map.of(
                "q", query
        );
    }

    @When("Se llama al request de buscar un Product")
    public void SearchProducts() {
        productsRequests.searchProducts(queryParamMap);
    }

    @Given("Se genera un request body de Product")
    public void generateRandomProduct() {
        product = Product.generateRamdonProduct();
    }

    @When("Se llama al request de crear un Product")
    public void createProduct() {
        productsRequests.createProduct(product);
    }

    @When("Se llama al request de actualizar un Product con id {int}")
    public void updateProduct(int id) {
        productsRequests.updateProduct(id, product);
    }

    @Given("Se genera un request body de Partial Product")
    public void generateRandomPartialProduct() {
        partialProduct = PartialProduct.generateRandomPartialProduct();
    }

    @When("Se llama al request de actualizar parcialmente un Product con id {int}")
    public void partialUpdateProduct(int id) {
        productsRequests.partialUpdateProduct(id, partialProduct);
    }
}
