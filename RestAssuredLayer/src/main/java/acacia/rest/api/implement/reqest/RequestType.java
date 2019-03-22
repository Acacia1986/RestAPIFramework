package acacia.rest.api.implement.reqest;

import acacia.rest.api.implement.response.ResponseType;
import acacia.rest.api.interfaces.IHttpType;
import io.restassured.response.Response;

import java.util.HashMap;
import static io.restassured.RestAssured.given;
/**
 * The class give use some common http method. Post,Get,Put,Delete....
 * This is a wrapper of HTTP method.
 */

public class RequestType implements IHttpType{
    public Response response;
    public ResponseType responseType;


    @Override
    public ResponseType GetRequestWithQueryPara(String URL, HashMap<String, String> params) {
         response = given().queryParams(params).when().get(URL);
         responseType = new ResponseType(response);
         return responseType;
    }

    @Override
    public ResponseType PostRequestWithQueryPara(String URL, HashMap<String, String> params) {
        response = given().queryParams(params).when().post(URL);
        responseType = new ResponseType(response);
        return responseType;
    }
}
