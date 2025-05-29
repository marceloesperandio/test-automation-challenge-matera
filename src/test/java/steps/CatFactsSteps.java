package steps;

import api.BreedApi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class CatFactsSteps {

    private final BreedApi breedApi = new BreedApi();
    private Response response;

    @Given("I send a GET request with limit {int}")
    public void iSendAGETRequestWithLimit(int limit) {
        response = breedApi.getBreedsWithLimit(String.valueOf(limit));
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        Assertions.assertEquals(expectedStatusCode, response.getStatusCode(),
                "Status code mismatch. Response body: " + response.getBody().asString());
    }

    @And("the breeds list should contain {int} items")
    public void theBreedsListShouldContainItems(int expectedSize) {
        int actualSize = response.jsonPath().getList("data").size();
        Assertions.assertEquals(expectedSize, actualSize,
                "Expected " + expectedSize + " breeds, but got " + actualSize);
    }

    @And("the breeds list should contain {int} item")
    public void theBreedsListShouldContainItem(int expectedSize) {
        int actualSize = response.jsonPath().getList("data").size();
        Assertions.assertEquals(expectedSize, actualSize,
                "Expected " + expectedSize + " breed, but got " + actualSize);
    }

    @Then("the response status code should not be {int}")
    public void theResponseStatusCodeShouldNotBe(int invalidStatusCode) {
        Assertions.assertNotEquals(invalidStatusCode, response.getStatusCode(),
                "Expected status code to be different from " + invalidStatusCode);
    }

    @Given("I send a GET request with invalid string limit")
    public void iSendAGETRequestWithInvalidStringLimit() {
        response = breedApi.getBreedsWithLimit("invalid");
    }
}