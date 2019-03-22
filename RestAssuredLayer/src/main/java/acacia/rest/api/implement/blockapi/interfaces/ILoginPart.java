package acacia.rest.api.implement.blockapi.interfaces;

import acacia.rest.api.implement.response.ResponseType;


public interface ILoginPart {

    /**
     * login to system.
     */
    ResponseType Login(String username, String pwd);





}
