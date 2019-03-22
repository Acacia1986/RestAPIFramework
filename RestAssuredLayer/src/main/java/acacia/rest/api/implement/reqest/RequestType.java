package acacia.rest.api.implement.reqest;

import acacia.rest.api.interfaces.IHttpType;
import io.restassured.response.Response;

import java.util.HashMap;
import static io.restassured.RestAssured.given;
/**
 * The class give use some common http method. Post,Get,Put,Delete....
 * This is a wrapper of HTTP method.
 */

public class HttpType implements IHttpType{
    public Response response;


    @Override
    public Response GetRequestWithQueryPara(String URL, HashMap<String, String> params) {
         response = given().queryParams(params).when().get(URL);
        return response;
    }

    @Override
    public Response PostRequestWithQueryPara(String URL, HashMap<String, String> params) {
        response = given().queryParams(params).when().post(URL);
        return response;
    }
}
