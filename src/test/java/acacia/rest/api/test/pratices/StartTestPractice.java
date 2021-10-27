package acacia.rest.api.test.pratices;

import acacia.rest.api.common.util.Configuration;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

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
        //Compare with every command.
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
        RestAssured.when().get(url).then().assertThat().statusCode(404);
        Response response = RestAssured.when().get(url);
        response.getBody().htmlPath().getNode("title").equals("Grizzly 2.3.23");
        response.getBody().prettyPrint();
    }

    @Test
    public void test_7(){
        String url = base_url + CATALOG_SEARCH_SERVICE;
        Response response = RestAssured.given().contentType("application/json").when().post(url);
        response.getBody().prettyPrint();
        Collection<String> collection = response.getCookies().values();

        while (collection.iterator().hasNext()) {
            System.out.println(collection.iterator().next());
        }
        //response.getCookie("ELOQUA").isEmpty();
    }

    //@Test
    public void test_8(){
        String url = base_url + "/dfml/service/lambdaApps";
        Response response = RestAssured.given().log().all().param("username","tester").when().get(url);
        response.getBody().prettyPrint();
        Map<String,String> cookies = response.getCookies();
        System.out.println(cookies);

    }

    @Test
    public void test_9(){
        String url = base_url + "/dfml/service/lambdaApps";
        Response response = RestAssured.given().log().all().cookie("test","qa").when().get(url);
        response.getBody().prettyPrint();
    }

    @Test
    public void test_10(){
        String url = base_url + CATALOG_SEARCH_SERVICE;
        Response response = RestAssured.given().log().all().contentType("application/json").post(url);
        response.then().body("took",equalTo(1));
//                RestAssured.given().log().all().contentType("application/json").post(url).
//                then().body("total",equalTo(5));
        response.getBody().prettyPrint();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        response.prettyPrint();
        System.out.println("################################");
        response.body().prettyPeek();
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        Boolean b = response.body().prettyPeek().path("hits.total").equals(2);
        System.out.println("B is : " + b);
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        response.body().print();
        System.out.println("***************************");
        response.print();
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        response.body().prettyPrint();
    }


    @Test
    public void test_11(){
        String url = base_url + CATALOG_SEARCH_SERVICE;
        Response response = RestAssured.given().log().all().contentType("application/json").post(url);
        response.then().body("_shards.total",equalTo(5));
        String body = response.getBody().toString();
        String cookies = response.getCookies().toString();
        String body_1 = response.body().toString();
        System.out.println("Body 1 is : " + body_1 );
        System.out.println("Body is :" + body);
        Boolean b = body.equalsIgnoreCase(body_1);
        Boolean a  = body == body_1;
        System.out.println("Equals or not " + b);
        System.out.println("Equals with == like:" + a);
        System.err.println("This equals error: " + body == body_1);
        System.err.println("This is a test: " + false);
        System.out.println("Cookies is : " + cookies);
    }

    @Test
    public void test_12() {
        String url = base_url + "/dfml/service/lambdaApps";
        Response response = RestAssured.given().log().all().head(url);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@");
        response.prettyPrint();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@");
        Headers headers = response.getHeaders();
        System.out.println("size is : " + headers.size());
        Header header = headers.iterator().next();
        for (Header h: headers) {
            System.out.format("Head name is %s, Head value is %s\n",header.getName(),header.getValue());
        }
    }

    @Test
    public void test_13(){
        String url = base_url + "/dfml/service/lambdaApps";
        Response response = RestAssured.given().log().all().header("Date","2016-2-2").get(url);
        response.body().prettyPrint();
        Headers headers = response.getHeaders();
        for (Header h: headers){
            System.out.format("Header name is %s, Header value is %s\n",h.getName(),h.getValue());
        }

    }

    @Test
    public void test_14(){
        String url = base_url + "/dfml/service/lambdaApps";
        Response response = RestAssured.given().log().all().headers("Accept-Language","en").get(url);
        response.body().prettyPrint();
        Headers headers = response.getHeaders();
        Iterator<Header> iterable = headers.iterator();
        while (iterable.hasNext()){
          Header header = iterable.next();
            System.out.format("Header name is %s, Header value is %s\n",header.getName(),header.getValue());
        }





    }



}
