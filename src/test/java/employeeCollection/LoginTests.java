package employeeCollection;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilites.Helper;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class LoginTests extends Helper {
    //RequestSpecification requestUrl;
    //String loginPath="/api/Account/login";
    /*
    @BeforeMethod
    public void setRequestSpecification() {
        requestUrl = given().baseUri("http://34.159.148.128");
    }

     */
    //protected String myToken;


    @Test
    public void testSuccessfulLogin() {

        HashMap<String,String> loginBody=new HashMap<>();
        loginBody.put("username",username);
        loginBody.put("password",password);

        given()
                .spec(requestUrl)
                .log().all()
                .contentType(ContentType.JSON)
                .body(loginBody)
                .when()
                .post(loginPath)
                .then()
                .assertThat().statusCode(200)
                .assertThat().body("token",not(empty()));

        Response response= given()
                .spec(requestUrl)
                .log().all()
                .contentType(ContentType.JSON)
                .body(loginBody)
                .when()
                .post(loginPath)
                .then()
                .extract().response();

        myToken=response.path("token");
        myToken=saveToken();
        System.out.println(myToken);

        //myToken=saveToken();
        //return myToken;

    }







}
