package utilites;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Helper {

    public static RequestSpecification requestUrl;
    protected String email="shah@example.com";
    protected String username="shah";
    protected String password="123456";

//    protected String newToken=saveToken();

    protected String myToken;


    protected String loginPath="/api/Account/login";

    @BeforeMethod
    public void setRequestSpecification() {
        requestUrl = given().baseUri("http://34.159.148.128");
        myToken=passToken();
    }

    public String saveToken(){
        System.out.println(myToken);
        return myToken;

    }


    public String passToken(){
        HashMap<String,String> loginBody=new HashMap<>();
        loginBody.put("username",username);
        loginBody.put("password",password);

        Response response= given()
                .spec(requestUrl)
                .log().all()
                .contentType(ContentType.JSON)
                .body(loginBody)
                .when()
                .post(loginPath)
                .then()
                .extract().response();

        String myToken=response.path("token");
        System.out.println(myToken);
        return myToken;
    }





}
