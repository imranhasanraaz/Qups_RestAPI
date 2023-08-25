package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIUtils {
    public static Response sendPostRequest(String url, Object post) {

        return RestAssured.given()
                .contentType("application/json")
                .body(post)
                .post(url);
    }

    public static Response sendGetRequest(String url) {
        return RestAssured.
                when().
                get(url);
    }
    public static Response sendPutRequest(String url, Object post) {

        return RestAssured.given()
                .contentType("application/json")
                .body(post)
                .put(url);
    }

    public static Response sendDeleteRequest(String url) {

        return RestAssured.
                when().
                delete(url);
    }
}