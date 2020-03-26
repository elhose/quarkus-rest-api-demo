package com.ttpsc;

import com.ttpsc.entity.Car;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class CarControllerTests {

    @Test
    public void testPost() {
        given()
                .when()
                .body(new Car("testName", BigDecimal.valueOf(123), "testColor"))
                .contentType(ContentType.JSON)
                .post("/cars")
                .then()
                .contentType("text/html;charset=UTF-8")
                .statusCode(400);
    }

    @Test
    public void testGet() {
        given()
                .when()
                .contentType(ContentType.JSON)
                .get("/cars")
                .then()
                .statusCode(500)
                .contentType("text/html;charset=UTF-8");
    }

    @Test
    public void testGet2() {
        given()
                .when()
                .contentType(ContentType.JSON)
                .get("/cars/2")
                .then()
                .statusCode(500)
                .contentType("text/html;charset=UTF-8");
    }

    @Test
    public void testGetExpensive() {
        given()
                .when()
                .contentType(ContentType.JSON)
                .get("/cars/top")
                .then()
                .statusCode(500)
                .contentType("text/html;charset=UTF-8");
    }

    @Test
    public void testDelete() {
        given()
                .when()
                .contentType(ContentType.JSON)
                .delete("/cars/123456")
                .then()
                .statusCode(500)
                .contentType("text/html;charset=UTF-8");
    }

    @Test
    public void testPut() {
        given()
                .when()
                .body(new Car("testName", BigDecimal.valueOf(123), "testColor"))
                .contentType(ContentType.JSON)
                .put("/cars/654321")
                .then()
                .statusCode(400)
                .contentType("text/html;charset=UTF-8");

    }
}