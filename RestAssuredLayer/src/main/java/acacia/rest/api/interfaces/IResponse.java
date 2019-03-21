package acacia.rest.api.interfaces;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * The interface about HTTP response
 */
public interface IResponse {

    /**
     * Get http response return status code.
     * @param response
     * @return
     */
    Integer getResponseStatusCode(Response response);

    /**
     * Get HTTP response content type.
     * @param response
     * @return
     */
    ContentType getResponseContentType(Response response);



}
