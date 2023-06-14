package iamquiz.controller;

import iamquiz.model.Player;
import iamquiz.model.SuperUser;
import iamquiz.model.User;
import iamquiz.view.GameScreen;
import java.util.ArrayList;
import java.util.Scanner;

public class GameScreenControl {
    private static String actualScreen = "mainMenu";
    private static char scannedCharacter = ' ';
    private final GameScreen gameScreen = new GameScreen();
    private static final Scanner sc = new Scanner(System.in);

    public static void setActualScreen(String actualScreen) {
        GameScreenControl.actualScreen = actualScreen;
    }

    public static char getScannedCharacter() {
        return scannedCharacter;
    }

    public static void setScannedCharacter() {      //scan from console
        try{
            scannedCharacter = sc.nextLine().charAt(0);
        }
        catch(Exception e){
            System.out.println("No character was entered.");
        }
    }
    public static void setScannedCharacter(String scannedString) {
        try{
            scannedCharacter = scannedString.charAt(0);
        }
        catch(Exception e){
            System.out.println("No character was entered.");
        }
    }

    public void checkForScannedCharacter(){     //method to switch game screens
        switch (actualScreen) {
            case "mainMenu" -> {
                gameScreen.displayMainMenu();
                setScannedCharacter();
                switch (scannedCharacter) {
                    case 'x' -> {
                        gameScreen.displayFullEndScreen();
                        System.exit(0);
                    }
                    case '1' -> actualScreen = "iamspeed";
                    case '2' -> actualScreen = "iamalive";
                    case '3' -> actualScreen = "weareinafight";
                    case '4' -> actualScreen = "superUserMenu";
                    default -> actualScreen = "mainMenu";
                }
            }
            case "iamspeed" -> {
                GameModeControl gameModeControl = new GameModeControl("I AM SPEED");
                gameScreen.displaySelectionMenu(actualScreen, gameModeControl.getGameMode().getDefaultTime());
                setScannedCharacter();
                switch (scannedCharacter) {
                    case 'x' -> actualScreen = "mainMenu";
                    case 'y' -> gameModeControl.setGameMode1Settings(scannedCharacter, gameScreen);
                }
            }
            case "iamalive" -> {
                GameModeControl gameModeControl = new GameModeControl("I AM ALIVE");
                gameScreen.displaySelectionMenu(actualScreen, gameModeControl.getGameMode().getDefaultLife());
                setScannedCharacter();

                switch (scannedCharacter) {
                    case 'x' -> actualScreen = "mainMenu";
                    default -> gameModeControl.setGameMode2Settings(scannedCharacter, gameScreen);
                }
            }
            case "weareinafight" -> {
                GameModeControl gameModeControl = new GameModeControl("WE ARE IN A FIGHT");
                gameScreen.displaySelectionMenu(actualScreen, gameModeControl.getGameMode().getNumberOfQuestions());
                setScannedCharacter();

                switch (scannedCharacter) {
                    case 'x' -> actualScreen = "mainMenu";
                    case 'y' -> gameModeControl.setGameMode3Settings(scannedCharacter, gameScreen);
                }

            }
            case "results" -> {
                setScannedCharacter();
                if (scannedCharacter == 'x') {
                    actualScreen = "mainMenu";
                }
            }
            case "superUserMenu" -> {
                gameScreen.displaySuperUserMenu();
                String password = sc.nextLine();
                if (SuperUserControl.isSuperUserLoggedIn(password)) {
                    actualScreen = "superUserLoggedInMenu";
                }
                else {
                    setScannedCharacter(password);
                    if (scannedCharacter == 'x') {
                        actualScreen = "mainMenu";
                    }
                }
            }
            case "superUserLoggedInMenu" -> {
                gameScreen.displaySuperUserMenu(SuperUserControl.isSuperUserLoggedIn());
                setScannedCharacter();
                switch (scannedCharacter) {
                    case 'x' -> actualScreen = "mainMenu";
                    case '1' -> actualScreen = "addQuestion";
                    case '2' -> actualScreen = "typesOfUsers";
                }
            }
            case "addQuestion" -> {
                FileHandling fileHandling = new FileHandling("sport.txt");
                fileHandling.addQuestion(gameScreen);
                gameScreen.displayQuestionAdded();
                setScannedCharacter();
                if (scannedCharacter != 'x') {
                    while (scannedCharacter != 'x') {
                        gameScreen.displayQuestionAdded();
                        setScannedCharacter();
                    }
                }
                actualScreen = "superUserLoggedInMenu";
            }
            case "typesOfUsers" -> {
                ArrayList<User> typesOfUsers = new ArrayList<User>();
                typesOfUsers.add(new Player());
                typesOfUsers.add(new SuperUser());
                gameScreen.displayTypesOfUsers(typesOfUsers);
                setScannedCharacter();
                if (scannedCharacter == 'x') actualScreen = "superUserLoggedInMenu";
            }
        }
    }
}
