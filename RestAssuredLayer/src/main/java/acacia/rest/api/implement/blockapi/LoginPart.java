package acacia.rest.api.implement.blockapi;

import acacia.rest.api.implement.blockapi.interfaces.ILoginPart;
import acacia.rest.api.implement.common.GetParaFromProperties;
import acacia.rest.api.implement.reqest.RequestType;
import acacia.rest.api.implement.response.ResponseType;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class LoginPart implements ILoginPart {

    Logger logger = LoggerFactory.getLogger(LoginPart.class);
    private static final String BASE_URL = GetParaFromProperties.getData("BASE_URL");
    private static final String LOGIN_URL = GetParaFromProperties.getData("LOGIN_URL");
    public RequestType requestType;
    public ResponseType responseType;

    /**
     * Collect the login URL.
     * @return
     */
    private static String URL(){
        return  BASE_URL + LOGIN_URL;
    }
    /**
     * login to system.
     */
    @Override
    public ResponseType Login(String username, String pwd) {
        logger.info("Start to login to system!");
        HashMap<String,String> users_pwd = new HashMap<>();
        users_pwd.put("loginName",username);
        users_pwd.put("password",pwd);
        requestType = new RequestType();
        responseType = requestType.PostRequestWithQueryPara(this.URL(),users_pwd);
        return  responseType;
    }





}
