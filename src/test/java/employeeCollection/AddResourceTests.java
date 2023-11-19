package employeeCollection;

import basePojo.AddResourcePojo;
import basePojo.AddServicePojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilites.Helper;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class AddResourceTests extends Helper {
    String addResourcePath="/api/Resource/add";
    String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MDAwNzQwNzMsImlzcyI6IllvdXJJc3N1ZXIiLCJhdWQiOiJZb3VySXNzdWVyIn0.LRo7hcLd9wT18AXNIl4SaU6c4Tt61DOHxLDHEg7UNpk";

    String[] clean=new String[]{"cleanUp"};

    AddResourcePojo body=new AddResourcePojo("vehicles","0",clean,"2:30:00",new int[]{5},"09:00:00","05:00:00");

    @Test
    public void testAddResource(){

        given()
                .spec(requestUrl)
                .auth().oauth2(myToken)
                .log().all()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(addResourcePath)
                .then()
                .log().all()
                .assertThat().statusCode(200);


    }



}
