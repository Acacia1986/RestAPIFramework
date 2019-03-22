package acacia.rest.api.interfaces;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public interface IVerification {


    /**
     * Verify the response content type is json.
     * @param response
     * @return
     */
    ValidatableResponse verifyContentTypeAsJson(Response response);


}
