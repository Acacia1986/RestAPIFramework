package com.sunray.api.auto.test.common.utils;


import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Optional;

import static io.restassured.RestAssured.given;

@Slf4j
public class HttpPostRequestUtil {


    /**
     * Get the token from a post request
     * @param apiURL
     * @param param
     * @return
     */
    public static String getToken(String apiURL, String param,String rootName, String defaultPropertiesFile) throws IOException {

        Response response = given()
                .config(withRelaxedHttpsValid())
                .contentType("application/json")
                .log().all()
                .request()
                .body(param)
                .when()
                .post(apiURL);
        String result = response.asString();
        JsonPath jsonPath = new JsonPath(result).setRootPath(rootName);
        String token = jsonPath.getString("token");
        Optional.ofNullable(token).orElse(FileUtil.getPropertiesFile(defaultPropertiesFile,"token"));
        log.info("Token is: " + token);
        return token;
    }

    /**
     * Define the URL and param,with post method to get response message
     * @param ApiUrl
     * @param Param
     * @return
     */
    public static String getMessage(String ApiUrl, String Param){
        Response response = given().config(withRelaxedHttpsValid())
                .contentType("application/json")
                .log().all()
                .request()
                .body(Param)
                .when()
                .post(ApiUrl);
        String message = response.jsonPath().get("message");
        return  message;
    }









    /**
     * util to set the ssl config of RestAssuredConfig.
     * @return
     */
    private static RestAssuredConfig withRelaxedHttpsValid(){
        return  RestAssuredConfig.config().sslConfig(new SSLConfig().relaxedHTTPSValidation());
    }

}
