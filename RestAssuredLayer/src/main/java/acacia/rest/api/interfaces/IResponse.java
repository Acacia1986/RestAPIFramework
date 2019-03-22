package acacia.rest.api.interfaces;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.util.List;

/**
 * The interface about HTTP response
 */
public interface IResponse {

    /**
     * Get http response return status code.
     *
     * @return
     */
    int getResponseStatusCode();



    /**
     * Extract the result from the HTTP response.
     * @param path the path of the parameter which want to extract.
     * @return
     */
    List<String> extractFromResponse(String path);


    /**
     * Get the content type of the response.
     * @return
     */
    String getResponseContentType();


    void printResponse();


}
