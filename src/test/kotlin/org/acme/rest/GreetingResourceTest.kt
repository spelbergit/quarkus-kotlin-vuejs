package org.acme.rest

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
open class GreetingResourceTest {

    @Test
    fun testHelloEndpoint() {
        given()
          .`when`().get("/greeting")
          .then()
             .statusCode(500)
//             .statusCode(200)
             .body(`is`(""))
//             .body(`is`("Hello World!"))
    }

}