package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 используя RestAssured написать тест на запрос
 GET https://swapi.dev/api/starships/10
 проверяющий статус код, значения полей
 name, cost_in_credits, length
 и количество пилотов в списке pilots
 */
public class SimpleApiTest {
//  Logger logger = LoggerFactory.getLogger(SimpleApiTest.class);
//  или
    Logger logger = LoggerFactory.getLogger(getClass()); //getClass() = Логировать текущий класс

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "https://swapi.dev";
    }

    @Test
    public void ok200test1() {
        logger.info("Start test");
        given().log().body()
                .when()
                .get("/api/starships/10")
                .then()
                .statusCode(200)
                .body( "name", equalTo("Millennium Falcon"))
                .body( "cost_in_credits", equalTo("100000"))
                .body("length", equalTo("34.37"));
        logger.info("End test");
    }

     /**
    {
        "name": "Millennium Falcon",
            "model": "YT-1300 light freighter",
            "manufacturer": "Corellian Engineering Corporation",
            "cost_in_credits": "100000",
            "length": "34.37",
            "max_atmosphering_speed": "1050",
            "crew": "4",
            "passengers": "6",
            "cargo_capacity": "100000",
            "consumables": "2 months",
            "hyperdrive_rating": "0.5",
            "MGLT": "75",
            "starship_class": "Light freighter",
            "pilots": [
        "https://swapi.dev/api/people/13/",
                "https://swapi.dev/api/people/14/",
                "https://swapi.dev/api/people/25/",
                "https://swapi.dev/api/people/31/"
    ],
        "films": [
        "https://swapi.dev/api/films/1/",
                "https://swapi.dev/api/films/2/",
                "https://swapi.dev/api/films/3/"
    ],
        "created": "2014-12-10T16:59:45.094000Z",
            "edited": "2014-12-20T21:23:49.880000Z",
            "url": "https://swapi.dev/api/starships/10/"
    }
*/

}

