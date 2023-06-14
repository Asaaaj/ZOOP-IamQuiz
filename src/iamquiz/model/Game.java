package iamquiz.model;

import java.util.ArrayList;

public class Game {
    private static final String GAMENAME = "I AM QUIZ";
    private static final ArrayList<String> gameModes = new ArrayList<>();

    static {
        gameModes.add("I AM SPEED");
        gameModes.add("I AM ALIVE");
        gameModes.add("WE ARE IN A FIGHT");
    }

    public static String getGAMENAME() {
        return GAMENAME;
    }

    public static ArrayList<String> getGameModes() {
        return  gameModes;
    }
}
