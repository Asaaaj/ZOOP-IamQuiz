package iamquiz.controller;

import iamquiz.model.SuperUser;
import java.util.Objects;

public class SuperUserControl {
    static SuperUser superUser = new SuperUser();

    public static boolean isSuperUserLoggedIn(){
        return superUser.isLoggedIn();
    }
    public static boolean isSuperUserLoggedIn(String password){         //check password
        if(Objects.equals(password, superUser.getPASSWORD())) {
            superUser.setLoggedIn(true);
            return true;
        }
        else return false;
    }
}
