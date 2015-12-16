package com.emmbi.mobile.example.events;


/**
 * Created by mbagliojr on 6/1/15.
 */
public class LogoutEvent {

    private Boolean logout;

    public LogoutEvent() {
        logout = true;
    }

    public Boolean logout() {
        return logout;
    }

}
