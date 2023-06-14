package iamquiz.model;

import java.util.ArrayList;

public interface Screens {
    void displayMainMenu();
    void displaySelectionMenu(String actualscreen, int defaultLife);
    void displayMode1Results(int playerLife, int playerCorrectQuestions);
    void displayMode2Results(int playerLife, int playerCorrectQuestions);
    void displayMode3Results(Player player1,Player player2);
    void displayMode1QuestionScreen(String question, ArrayList<String> answers, int numberOfAnsweredQuestions, int playerLife);
    void displayMode2QuestionScreen(String question, ArrayList<String> answers, int numberOfAnsweredQuestions, int numberOfQuestions, int playerLife);
    void displayMode3QuestionScreen(String question, ArrayList<String> answers, int numberOfAnsweredQuestions, int numberOfQuestions);
    void displaySuperUserMenu();
    void displaySuperUserMenu(boolean superUserLoggedIn);
    void displaySuperUserMenu(String actualScreen);
    void displayAddQuestion();
    void displayAddCorrectAnswer();
    void displayAddIncorrectAnswer();
    void displayQuestionAdded();
    void displayTypesOfUsers(ArrayList<User> typesOfUsers);
    default void displayEndScreen(){
        System.out.println("|\n|\n|\n|\t\t\t\t\t\tThank you for playing!\n|\n|\n|");
    }


}


