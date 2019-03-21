package acacia.rest.api.block.test.delivery;
import acacia.rest.api.implement.common.GetParaFromProperties;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * This class force one deliver login to Block
 */
public class LoginPage {


    Logger logger = LoggerFactory.getLogger(LoginPage.class);
    private static final String BASE_URL = GetParaFromProperties.getData("BASE_URL");
    private static final String LOGIN_URL = GetParaFromProperties.getData("LOGIN_URL");
    private static final String UNINITIAL_URL = GetParaFromProperties.getData("UNINITIAL_URL");
    public String token;

    @Test
    public void LoginToBLockServer(){
        logger.info("Start to login to system!");
        String url = BASE_URL + LOGIN_URL;
        HashMap<String,String> users_pwd = new HashMap<>();
        users_pwd.put("loginName","qa");
        users_pwd.put("password","cf79ae6addba60ad018347359bd144d2");
        Response response = given().queryParams(users_pwd).when().post(url);
        response.then().assertThat().statusCode(200);
        response.then().assertThat().contentType(ContentType.JSON);
        response.prettyPrint();
        token = response.then().extract().path("result.token");
        System.out.println("Token : " + token);
        List<String> menusList = new ArrayList<>();
        List<String> menus =  response.then().extract().path("result.menus");

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
        params.put("token",token);
        Response response = given().queryParams(params).when().post(url);
        response.prettyPrint();
        List<String> deliveryCode = response.then().extract().path("result.deliverys.deliveryCode");
        for (String code:deliveryCode) {
            System.out.println(code);
        }



    }
















}
