package employeeCollection;

import basePojo.AddResourcePojo;
import org.testng.annotations.Test;
import utilites.Helper;

import static io.restassured.RestAssured.given;

public class ViewResourcesTests extends Helper {

    String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MDAwNzQwNzMsImlzcyI6IllvdXJJc3N1ZXIiLCJhdWQiOiJZb3VySXNzdWVyIn0.LRo7hcLd9wT18AXNIl4SaU6c4Tt61DOHxLDHEg7UNpk";
    String viewResourcePath="/api/Resource/get";

    @Test
    public void testViewResources(){

        given()
                .spec(requestUrl)
                .queryParam("companyId",0)
                .auth().oauth2(myToken)
                .log().all()
                .when()
                .get(viewResourcePath)
                .then()
                .log().all()
                .assertThat().statusCode(200);
    }

}

