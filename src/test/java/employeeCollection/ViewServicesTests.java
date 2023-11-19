package employeeCollection;

import org.testng.annotations.Test;
import utilites.Helper;

import static io.restassured.RestAssured.given;

public class ViewServicesTests extends Helper {

    String viewServicePath="/api/Service/get";
    //String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MDAwMTMxODksImlzcyI6IllvdXJJc3N1ZXIiLCJhdWQiOiJZb3VySXNzdWVyIn0._YpBfIGgZLxtfXHN3pEz8KkJ17zyGtRSKTInsk1WioQ";

    @Test
    public void testViewService(){

        /*HashMap<String,int> queryParams=new HashMap<>();
        queryParams.put("companyID",1);
        */


        //queryParam("companyID",15),
        //"company_id": 0,//although used 15 in AddService
        //        "name": "cleanUp"


        given()
                .spec(requestUrl)
                .queryParam("companyID",0)
                .auth().oauth2(myToken)
                .log().all()
                .when()
                .get(viewServicePath)
                .then()
                .log().all()
                .assertThat().statusCode(200);

    }

}
