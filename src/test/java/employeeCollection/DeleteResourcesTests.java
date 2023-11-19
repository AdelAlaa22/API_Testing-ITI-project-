package employeeCollection;

import org.testng.annotations.Test;
import utilites.Helper;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteResourcesTests extends Helper {

    String deleteResourcePath = "/api/Resource/delete";

    @Test
    public void testDeleteResource() {

        //DeletePojo deletePojo=new DeletePojo(0,"cleanUp");

        given()
                .spec(requestUrl)
                .queryParams("companyId", 0, "resourceName", "vehicles")
                .auth().oauth2(myToken)
                .log().all()
                .when().delete(deleteResourcePath)
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .body(equalTo("Resource Deleted Successfully"));

    }
}