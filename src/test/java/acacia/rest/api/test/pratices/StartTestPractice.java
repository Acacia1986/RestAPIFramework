package acacia.rest.api.test.pratices;

import acacia.rest.api.common.util.Configuration;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

/**
 * Created by miaomiao on 6/14/2017.
 */
public class StartTestPractice {
    public final String Host_URL = Configuration.getValue("Host", "bej301748.cn.oracle.com:");
    public final String PORT = Configuration.getValue("Port", "5001");
    public final String PROTOCOL = Configuration.getValue("protocol", "http://");
    public final String CATALOG_SEARCH_SERVICE = "/dip/service/v1/catalog/search/";

    public final String base_url = PROTOCOL + Host_URL + PORT;

    @Test
    public void test_1() {
        String testValue = Configuration.getValue("Host", "99");
        System.out.println("@@@@" + testValue);
    }

    @Test
    public void test_2() {
        System.setProperty("config.file", "miaomiao.properties");
        String test = System.getProperty("config.file");
        System.out.println("@@@@" + test);
    }

    @Test
    public void test_3() throws MalformedURLException {
        String url = base_url + CATALOG_SEARCH_SERVICE;
        //Response response = RestAssured.given().log().all().contentType("application/json").urlEncodingEnabled(false).given().post(url);
        //Response response = RestAssured.given().log().all().contentType("application/json").post(url);
        //Response response = RestAssured.given().contentType("application/json").post(url);
        //Response response = RestAssured.given().contentType("application/json").log().all().urlEncodingEnabled(false).post(url);
        Response response = RestAssured.given().contentType("application/json").post(url);
        System.out.println("Response is:\n" + response.getStatusCode());
        response.getBody().prettyPrint();
    }

    @Test
    public void test_4() {
        String url = base_url + "/dfml/service/lambdaApps";
        Header header = new Header("ACCEPT-LANGUAGE", "en");
        //Response response = RestAssured.given().get(url);
        //Response response = RestAssured.when().get(url);
        Response response = RestAssured.get(url);
        response.getBody().prettyPrint();
    }

    @Test
    public void test_5() {
        String url = base_url + "/dfml/service/lambdaApps";
        RestAssured.when().get(url).then().assertThat().statusCode(404);
    }

    @Test
    public void test_6(){
        String url = base_url + "/dfml/service/lambdaApps";
        RestAssured.when().get(url).then().assertThat().statusCode(404).and().assertThat().
    }


}
