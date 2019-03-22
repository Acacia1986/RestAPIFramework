package acacia.rest.api.interfaces;

import acacia.rest.api.implement.response.ResponseType;
import io.restassured.response.Response;

import java.util.HashMap;

/**
 * List all the support methods of HTTP
 */
public interface IHttpType {


    /**
     * HTTP Get method
     * @param URL
     * @param params
     * @return
     */
    ResponseType GetRequestWithQueryPara(String URL, HashMap<String,String> params);

    /**
     * HTTP Post method
     * @param URL
     * @param params
     * @return
     */
    ResponseType PostRequestWithQueryPara(String URL, HashMap<String,String> params);






}
