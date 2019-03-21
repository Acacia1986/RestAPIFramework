package acacia.rest.api.interfaces;

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
    Response GetRequestWithQueryPara(String URL, HashMap<String,String> params);

    /**
     * HTTP Post method
     * @param URL
     * @param params
     * @return
     */
    Response PostRequestWithQueryPara(String URL,HashMap<String,String> params);






}
