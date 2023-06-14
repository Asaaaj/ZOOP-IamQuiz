package iamquiz.view;

import iamquiz.model.*;
import java.util.ArrayList;
import java.util.Objects;

public class GameScreen extends QuizScreen implements Screens{
    Game game = new Game();
    public static void displayBorder(String superUser) {    //Top border for superuser menu
        if(Objects.equals(superUser, "superuser")){
            System.out.println("                               ___________");
            System.out.println("______________________________| " + "SUPERUSER" + " |______________________________");
            System.out.println("|                              ‾‾‾‾‾‾‾‾‾‾‾");
        }
    }
     public void displayMainMenu() {
         displayBorder();
         System.out.println("|\tSELECT A GAME MODE");
         for(int index = 0; index < game.getGameModes().size() ; index++) {
             System.out.println("|\t("+ (index + 1) + ")   " + game.getGameModes().get(index));
         }
         System.out.println("|\n|Press '4' for Superuser mode");
         System.out.println("|Press 'x' for end the quiz");
         displayBorderBottom();
    }
    public void displaySelectionMenu(String actualScreen, int defaultLife) {
        displayBorder();
        System.out.print("|\tSELECTED MODE: ");
        switch (actualScreen) {
            case "iamspeed" -> {
                System.out.println("I AM SPEED");
                System.out.println("|\tDefault settings:");
                System.out.println("|\t\tTime in seconds:" + defaultLife);
            }
            case "iamalive" -> {
                System.out.println("I AM ALIVE");
                System.out.println("|\tDefault settings:");
                System.out.println("|\t\tLife:" + defaultLife);
            }
            case "weareinafight" -> {
                System.out.println("WE ARE IN A FIGHT");
                System.out.println("|\tDefault settings:");
                System.out.println("|\tNumber of Questions:" + defaultLife);
            }
        }
        System.out.println("|\n|\n|\n|Press 'x' to go back\t\t\t\t\t\t\t\tPress 'y' to begin");
        displayBorderBottom();
    }
    public void displayMode1QuestionScreen(String question, ArrayList<String> answers, int numberOfAnsweredQuestions, int playerLife){
        displayBorder();
        System.out.print("|\tQUESTION " + numberOfAnsweredQuestions);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t  Time: " + playerLife);
        System.out.println("|\t" + question);
        for(int index = 1; index < 5; index++){
            System.out.println("|\t\t(" + index + ") " + answers.get(index-1));
        }
        System.out.println("|");

        displayBorderBottom();
    }

    public void displayMode2QuestionScreen(String question, ArrayList<String> answers, int numberOfAnsweredQuestions, int numberOfQuestions, int playerLife){
        displayBorder();
        System.out.print("|\tQUESTION " + numberOfAnsweredQuestions + " OUT OF " + numberOfQuestions);
        System.out.println("\t\t\t\t\t\t\t\t\t\t  Life: " + playerLife);
        System.out.println("|\t" + question);
        for(int index = 1; index < 5; index++){
            System.out.println("|\t\t(" + index + ") " + answers.get(index-1));
        }
        System.out.println("|");
        displayBorderBottom();
    }

    public void displayMode3QuestionScreen(String question, ArrayList<String> answers, int numberOfAnsweredQuestions, int numberOfQuestions) {
        char[] player2Index = {'Q' , 'W' , 'E', 'R'};
        displayBorder();
        System.out.println("|\tQUESTION " + numberOfAnsweredQuestions + " OUT OF " + numberOfQuestions);
        System.out.println("|\t" + question);
        for(int index = 1; index < 5; index++){
            System.out.println("|\t\t(" + index + ") (" + player2Index[index-1] + ") " + answers.get(index-1));
        }
        System.out.println("|");

        displayBorderBottom();
    }

    public void displayMode1Results(int playerLife, int playerCorrectQuestions){
        displayBorder();
        System.out.println("|\t\t\t\t\t\t   YOU RAN OUT OF TIME!");
        System.out.println("|\tStats:\n" + "|\tTime:  " + playerLife + "\n|\tCorrectly answered questions:  " + playerCorrectQuestions);
        System.out.println("|\n|");
        System.out.println("|Press 'x' to go back to menu");
        displayBorderBottom();
    }

    public void displayMode2Results(int playerLife, int playerCorrectQuestions){
         displayBorder();
         if(playerLife > 0) {
             System.out.println("|\t\t\t\t\t\t\t\tYOU WON");
         }
         else {
             System.out.println("|\t\t\t\t\t\t\t\tYOU LOST");
         }
        System.out.println("|\tStats:\n" + "|\tRemaining life:  " + playerLife + "\n|\tCorrectly answered questions:  " + playerCorrectQuestions);
        System.out.println("|\n|");
        System.out.println("|Press 'x' to go back to menu");
        displayBorderBottom();
    }

    public void displayMode3Results(Player player1, Player player2){
        displayBorder();
        if(player1.getCorrectQuestions() > player2.getCorrectQuestions()) {
            System.out.println("|\t\t\t\t\t\t\t   " + player1.getName().toUpperCase() + " WON");
        } else if(player1.getCorrectQuestions() < player2.getCorrectQuestions()) {
            System.out.println("|\t\t\t\t\t\t\t   " + player2.getName().toUpperCase() + " WON");
        }
        else {
            System.out.println("|\t\t\t\t\t\t\t\tTIE");
        }
        player1.displayMode3Stats();
        player2.displayMode3Stats();
        System.out.println("|\n|Press 'x' to go back to menu");
        displayBorderBottom();
    }

    public void displayFullEndScreen(){
        displayBorder();
        displayEndScreen();
        displayBorderBottom();
    }

    public void displaySuperUserMenu() {
        displayBorder();
        System.out.println("|\n|\t\t\t\t\t\t\t SUPERUSER MENU\n|\t\t\t\t\t\t\tEnter a password\n|\n|\n|\n|Press 'x' to go back");
        displayBorderBottom();
    }
    public void displaySuperUserMenu(boolean superUserLoggedIn) {
        if (superUserLoggedIn) {
            displayBorder("superuser");
            System.out.println("|\t\t\t\t\t\t\t SUPERUSER MENU");
            System.out.println("|\tSELECT AN OPTION");
            System.out.println("|\t(1)  Add a new Question\n|\t(2)  Types of Users in I AM QUIZ\n|\n|\n|Press 'x' for log out");
            displayBorderBottom();
        }
    }
    public void displaySuperUserMenu(String actualScreen) {
         displayBorder();
         System.out.println("|\t\t\t\t\t\t\t SUPERUSER MENU");
         switch (actualScreen) {
             case "addQuestion" -> System.out.println("|\tAdding a new Question");
             case "deleteQuestion" -> System.out.println("|\tDeleting a Question");
         }
         System.out.println("|\n|\n|\n|\n|Press 'x' to go back");
         displayBorderBottom();
    }
    public void displayAddQuestion(){
        displayBorder();
        System.out.println("|\n|\n|\t\t\t\t\t\t\t SUPERUSER MENU\n|\t\t\t\t\t\t   Add a new Question\n|\n|\n|");
        displayBorderBottom();
    }
    public void displayAddCorrectAnswer(){
        displayBorder();
        System.out.println("|\n|\n|\t\t\t\t\t\t\t SUPERUSER MENU\n|\t\t\t\t\t\t  Add a Correct Answer\n|\n|\n|");
        displayBorderBottom();
    }
    public void displayAddIncorrectAnswer(){
        displayBorder();
        System.out.println("|\n|\n|\t\t\t\t\t\t\t SUPERUSER MENU\n|\t\t\t\t\t\t Add an Incorrect Answer\n|\n|\n|");
        displayBorderBottom();
    }
    public void displayQuestionAdded() {
        displayBorder();
        System.out.println("|\n|\n|\t\t\t\t\t\tQUESTION HAS BEEN ADDED\n|\n|\n|");
        System.out.println("|Press 'x' to go back to menu");
        displayBorderBottom();
    }
    public void displayTypesOfUsers(ArrayList<User> typesOfUsers) {
        displayBorder();
        System.out.println("|\n|\t\t\t\t\t\t\t SUPERUSER MENU\n|\tTypes of users in quiz:");
        for (User typesOfUser : typesOfUsers) {
            System.out.println("|\t\t" + typesOfUser.whoAmI());
        }
        System.out.println("|\n|Press 'x' to go back to menu");
        displayBorderBottom();
    }
}
