package acacia.rest.api.block.test.delivery;
import acacia.rest.api.implement.blockapi.LoginPart;
import acacia.rest.api.implement.common.GetParaFromProperties;
import acacia.rest.api.implement.response.ResponseType;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.bind.SchemaOutputResolver;
import java.util.HashMap;
import java.util.List;
import static io.restassured.RestAssured.given;

/**
 * This class force one deliver login to Block
 */
public class LoginPage {


    Logger logger = LoggerFactory.getLogger(LoginPage.class);
    private static final String USER_NAME = GetParaFromProperties.getData("USER_NAME");
    private static final String USER_PWD = GetParaFromProperties.getData("USER_PWD");
    public ResponseType response;


    private static final String BASE_URL = GetParaFromProperties.getData("BASE_URL");
    private static final String LOGIN_URL = GetParaFromProperties.getData("LOGIN_URL");
    private static final String UNINITIAL_URL = GetParaFromProperties.getData("UNINITIAL_URL");
    public String token;

    @Test
    public void LoginToBLockServer(){
        LoginPart login = new LoginPart();
        response =  login.Login(USER_NAME,USER_PWD);
        int statusCode = response.getResponseStatusCode();
        Assert.assertEquals(statusCode,200);
        String contentType = response.getResponseContentType();
        response.printResponse();
        //token = response.extractFromResponse("result.token");

        //System.out.println("Token : " + token);
        List<String> menus =  response.extractFromResponse("result.menus");

        for (int i = 0; i < menus.size(); i++) {
            System.out.println(menus.get(i));
        }

    }




    /**
     * Get uninitialized list of block
     */
    @Test(dependsOnMethods = "LoginToBLockServer")
    public void getUninitialList(){
        logger.info("Start to get uninitialized list of BLock!");
        String url = BASE_URL + UNINITIAL_URL;
        HashMap<String,String> params = new HashMap<>();
       // params.put("token",token);
        Response response = given().queryParams(params).when().post(url);
        response.prettyPrint();
        List<String> deliveryCode = response.then().extract().path("result.deliverys.deliveryCode");
        for (String code:deliveryCode) {
            System.out.println(code);
        }



    }
















}
