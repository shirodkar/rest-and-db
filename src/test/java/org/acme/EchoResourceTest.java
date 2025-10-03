package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class EchoResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/echo/hello")
          .then()
             .statusCode(200)
             .body(is("hello...hello...hello...hello... stored in db!"));
    }

}