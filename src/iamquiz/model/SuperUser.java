package iamquiz.model;

public class SuperUser extends Player{
    private final String PASSWORD = "quiz1234";
    private boolean loggedIn = false;

    public String getPASSWORD() {
        return PASSWORD;
    }

    public final boolean isLoggedIn() {
        return loggedIn;
    }

    public boolean setLoggedIn(boolean loggedIn) { //log in or log out superuser
        this.loggedIn = loggedIn;
        return this.loggedIn;
    }

    @Override
    public String whoAmI() {
        return "I am type of: SuperUser";
    }
}
