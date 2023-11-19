package employeeCollection;


import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilites.Helper;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

public class RegisterTests extends Helper {

    //RequestSpecification requestUrl;
    String registerPath="/api/Account/register";

   /*
    @BeforeMethod
    public void setRequestSpecification() {
        requestUrl = given().baseUri("http://34.159.148.128");
    }

    */

    @Test
    public void testSuccessfulRegister() {

        HashMap <String,String> registerBody=new HashMap<>();
        registerBody.put("username",username);
        registerBody.put("email",email);
        registerBody.put("password",password);

        given()
                .spec(requestUrl)
                .log().all()
                .contentType(ContentType.JSON)
                .body(registerBody)
                .when()
                    .post(registerPath)
                .then()
                    .log().all()
                    .assertThat()
                    .statusCode(200)
                    .body("message",equalTo("Registration successful"))
    ;}


}
