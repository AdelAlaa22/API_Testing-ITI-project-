package employeeCollection;


import basePojo.AddServicePojo;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import utilites.Helper;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddServiceTests extends Helper {

    //another idea to make addService inherit from login
    String addServicePath="/api/Service/add";
    //String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MDAwMDUwNTcsImlzcyI6IllvdXJJc3N1ZXIiLCJhdWQiOiJZb3VySXNzdWVyIn0.ioDkiKETKnK2bYc-8elj1ub-qw2Q_lzhdSsYrQuJ7a8";

    /*int companyId=15;
    String name="cleanUp";
    String defaultDuration= "02:30:00";
    int price=500;

     */
    @Test
    public void testAddService(){

        /*HashMap<String,String> addServiceBody=new HashMap<>();
        addServiceBody.put("company_id",companyId);
        addServiceBody.put("name",name);
        addServiceBody.put("defaultDuration",defaultDuration);
        addServiceBody.put("price",price);
*/
        AddServicePojo body=new AddServicePojo(15,"cleanUp","02:30:00",500);

        given()
                .spec(requestUrl)
                .auth().oauth2(myToken)
                .log().all()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                    .post(addServicePath)
                .then()
                    .log().all()
                    .assertThat().statusCode(200);


    }


    //headers.get("server")).to.include("Kestrel");
    //.assertThat().header(("Server",equalTo("Kestrel"));



}
