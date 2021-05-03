package br.ce.opah.test;

import br.ce.opah.core.BaseTest;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestDeck extends BaseTest {

    @Test
    public void cosultaDeck(){
        given()

        .when()
            .get("new/shuffle/?deck_count=1")
        .then()
            .statusCode(200)
            .body("remaining", is(52))
            .body("success", is(true))
        ;
    }

    @Test
    public void deverRetornarErroNoStatusCode(){
        given()

        .when()
            .get("new/shuffle/?deck_count=1")
        .then()
            .statusCode(400)
        ;
    }

    @Test
    public void deveRetornarIDDeck(){
        given()

        .when()
             .get("7musgkktg8h9/draw/?count=2")
        .then()
             .statusCode(200)
             .body("success",is(true))
             .body("deck_id", is("7musgkktg8h9"))
        ;

    }

    @Test
    public void deveRetornarErroNoStatusCode(){
        given()

        .when()
                .get("7musgkktg8h9/draw/?count=2")
        .then()
                .statusCode(400);
    }
}
