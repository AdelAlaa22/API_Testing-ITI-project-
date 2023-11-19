package employeeCollection;

import basePojo.DeletePojo;
import org.testng.annotations.Test;
import utilites.Helper;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteServiceTests extends Helper {
    String deletePath="/api/Service/delete";
    //String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MDAwMTMxODksImlzcyI6IllvdXJJc3N1ZXIiLCJhdWQiOiJZb3VySXNzdWVyIn0._YpBfIGgZLxtfXHN3pEz8KkJ17zyGtRSKTInsk1WioQ";

    @Test
    public void testDeleteService(){

        //DeletePojo deletePojo=new DeletePojo(0,"cleanUp");

        given()
                .spec(requestUrl)
                .queryParams("companyId",0,"ServiceName","cleanUp")
                .auth().oauth2(myToken)
                .log().all()
                .when() .delete(deletePath)
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .body(equalTo("Service Deleted Successfully"));

        System.out.println(myToken);


    }

}
