package acacia.rest.api.implement.response;

import acacia.rest.api.interfaces.IResponse;

import io.restassured.response.Response;

import java.util.List;

public class ResponseType implements IResponse {
    public Response response;

    public ResponseType(Response response) {
        this.response = response;
    }

    @Override
    public int getResponseStatusCode() {
        int state_Code = response.statusCode();
        return state_Code;
    }



    @Override
    public List<String> extractFromResponse(String path) {
        List<String> result = response.then().extract().path(path);
        return result;
    }


    @Override
    public String getResponseContentType() {
        String content = response.contentType().split(";")[0];
        return content;
    }

    @Override
    public void printResponse() {
        response.prettyPrint();
    }


}

