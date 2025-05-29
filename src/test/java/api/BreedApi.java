package api;

import constants.Endpoints;
import constants.Path;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.filter.log.LogDetail.ALL;

public class BreedApi {

    private RequestSpecification requestSpec = new RequestSpecBuilder()
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .setBaseUri(Endpoints.BASE_URL_CATFACT_API)
            .log(ALL)
            .build();

    public Response getBreedsWithLimit(String limit) {
        return given()
                .spec(requestSpec)
                .queryParam("limit", limit)
                .get(Path.GET_BREEDS)
                .then()
                .extract()
                .response();
    }
}