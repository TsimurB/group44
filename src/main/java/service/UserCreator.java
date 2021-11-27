package service;

import models.User;

public class UserCreator {

    public static final String USERNAME = "Group44";
    public static final String USERPASS = "Password1!";
    public static final String USERMAIL = "group44testuser@yopmail.com";
    public static final String USERMAILPASS = "";

    public static User withNameAndPass() {
        return new User(USERNAME, USERPASS);
    }


}
