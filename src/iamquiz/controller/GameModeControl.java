package iamquiz.controller;

import iamquiz.model.*;
import iamquiz.view.GameScreen;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class GameModeControl {
    GameMode gameMode = new GameMode();

    public GameModeControl(String gameModeName){
        gameMode.setGameModeName(gameModeName);
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public int randomNumber(int min, int max){      //getting random number
        return (int)(Math.random() * (max - min) + min);
    }

    public ArrayList<Category> randomize(ArrayList<Category> categories) {      // method for randomizing answers and questions
        for (int indexOfCategory = 0; indexOfCategory < categories.size(); indexOfCategory++) {
            for (int indexOfQuestion = 0; indexOfQuestion < categories.get(indexOfCategory).getQuestions().size(); indexOfQuestion++) {
                for (int indexOfAnswer = 0; indexOfAnswer < 4; indexOfAnswer++) {
                    int firstNum = randomNumber(0, 4);
                    int secondNum = randomNumber(0, 4);
                    if (firstNum == categories.get(indexOfCategory).getQuestions().get(indexOfAnswer).getIndexOfCorrectAnswer()) {
                        categories.get(indexOfCategory).getQuestions().get(indexOfAnswer).setIndexOfCorrectAnswer(secondNum);
                    } else if (secondNum == categories.get(indexOfCategory).getQuestions().get(indexOfAnswer).getIndexOfCorrectAnswer()) {
                        categories.get(indexOfCategory).getQuestions().get(indexOfAnswer).setIndexOfCorrectAnswer(firstNum);
                    }
                    Collections.swap(categories.get(indexOfCategory).getQuestions().get(indexOfAnswer).getAnswers(), firstNum, secondNum);
                }
                Collections.swap(categories.get(indexOfCategory).getQuestions(), randomNumber(0, categories.get(indexOfCategory).getQuestions().size()), randomNumber(0, categories.get(indexOfCategory).getQuestions().size()));
            }
            Collections.swap(categories, randomNumber(0, categories.size()), randomNumber(0, categories.size()));
        }
        return categories;
    }

    public ArrayList<Category> loadQuestions() {        //method for calling method to load questions from a file
        FileHandling fileHandling = new FileHandling("sport.txt");
        ArrayList<Category> categories = new ArrayList<>();
        Category category = fileHandling.loadFile();
        categories.add(category);
        return categories;
    }
    public void setGameMode1Settings(char scannedCharacter, GameScreen gameScreen){     //settings for mode 1
        GameMode gameMode = new GameMode();
        Player player = new Player();

        if (scannedCharacter == 'y') {
            player.setTime(gameMode.getDefaultTime());
            player.setLife(1);
            gameMode.setCategories(randomize(loadQuestions()));
            startGame1(gameScreen, gameMode, player);
        }

    }

    public void startGame1(GameScreen gameScreen, GameMode gameMode, Player player){       //mode 1
        int numberOfAnsweredQuestions = gameMode.getNumberOfAnsweredQuestions();
        int indexOfQuestion = 0;

        while(player.getLife() > 0) {
            Question question = gameMode.getCategories().get(0).getQuestions().get(indexOfQuestion);
            gameScreen.displayMode1QuestionScreen(question.getQuestion(), question.getAnswers(), numberOfAnsweredQuestions, player.getTime());
            LocalTime printTime = LocalTime.now();

            GameScreenControl.setScannedCharacter();

            LocalTime answerTime = LocalTime.now();
            Duration duration = Duration.between(printTime, answerTime);

            if(duration.toSeconds() <= player.getTime()) {
                if (handleCorrectAnswer(GameScreenControl.getScannedCharacter(), question.getIndexOfCorrectAnswer())) {
                    player.setCorrectQuestions();
                }
            }
            else {
                player.setLife(0);
            }
            numberOfAnsweredQuestions++;
            indexOfQuestion++;

            if(indexOfQuestion >= gameMode.getCategories().get(0).getQuestions().size()){
                gameMode.setCategories(randomize(gameMode.getCategories()));
                indexOfQuestion = 0;
                player.setTime(player.getTime() - 1);
            }
        }
        gameScreen.displayMode1Results(player.getTime(), player.getCorrectQuestions());
        GameScreenControl.setActualScreen("results");

    }

    public void setGameMode2Settings(char scannedCharacter, GameScreen gameScreen) {        //settings for mode 2
        GameMode gameMode = new GameMode();
        if (scannedCharacter == 'y') {
            gameMode.setCategories(randomize(loadQuestions()));
            startGame2(gameScreen, gameMode);
        }
    }

    public void startGame2(GameScreen gameScreen, GameMode gameMode){       //mode 2
        Player player1 = new Player();
        player1.setLife(gameMode.getDefaultLife());
        int numberOfQuestions = gameMode.getNumberOfQuestions();
        int numberOfAnsweredQuestions = gameMode.getNumberOfAnsweredQuestions();
        int indexOfQuestion = 0;

        while(player1.getLife() > 0 && numberOfAnsweredQuestions <= numberOfQuestions) {
            Question question = gameMode.getCategories().get(0).getQuestions().get(indexOfQuestion);
            gameScreen.displayMode2QuestionScreen(question.getQuestion(), question.getAnswers(), numberOfAnsweredQuestions, numberOfQuestions, player1.getLife());
            GameScreenControl.setScannedCharacter();
            if (handleCorrectAnswer(GameScreenControl.getScannedCharacter(), question.getIndexOfCorrectAnswer())) {
                player1.setCorrectQuestions();
            }
            else {
                player1.setLife(player1.getLife()-1);
            }
            numberOfAnsweredQuestions++;
            indexOfQuestion++;
            if(indexOfQuestion >=  gameMode.getCategories().get(0).getQuestions().size()){
                gameMode.setCategories(randomize(gameMode.getCategories()));
                indexOfQuestion = 0;
            }
        }
        gameScreen.displayMode2Results(player1.getLife(), player1.getCorrectQuestions());
        GameScreenControl.setActualScreen("results");
    }

    public void setGameMode3Settings(char scannedCharacter, GameScreen gameScreen){         //settings for mode 3
        User user1 = new Player();
        User user2 = new Player();
        GameMode gameMode = new GameMode();
        if (scannedCharacter == 'y') {
            user1.setName("Player 1");
            user2.setName("Player 2");
            gameMode.setCategories(randomize(loadQuestions()));
            startGame3(gameScreen, (Player)user1, (Player)user2, gameMode);
        }
    }

    public void startGame3(GameScreen gameScreen, Player player1, Player player2, GameMode gameMode){       //mode3
        int numberOfAnsweredQuestions = gameMode.getNumberOfAnsweredQuestions();
        int indexOfQuestion = 0;

        while(numberOfAnsweredQuestions <= gameMode.getNumberOfQuestions()) {
            Question question = gameMode.getCategories().get(0).getQuestions().get(indexOfQuestion);
            gameScreen.displayMode3QuestionScreen(question.getQuestion(), question.getAnswers(), numberOfAnsweredQuestions, gameMode.getNumberOfQuestions());
            GameScreenControl.setScannedCharacter();

            switch(GameScreenControl.getScannedCharacter()) {
                case '1', '2', '3', '4' -> {
                    if (handleCorrectAnswer(GameScreenControl.getScannedCharacter(), question.getIndexOfCorrectAnswer())) {
                        player1.setCorrectQuestions();
                    }
                }
                case 'q' -> {
                    if (handleCorrectAnswer('1', question.getIndexOfCorrectAnswer())) {
                        player2.setCorrectQuestions();
                    }
                } case 'w' -> {
                    if (handleCorrectAnswer('2', question.getIndexOfCorrectAnswer())) {
                        player2.setCorrectQuestions();
                    }
                } case 'e' -> {
                    if (handleCorrectAnswer('3', question.getIndexOfCorrectAnswer())) {
                        player2.setCorrectQuestions();
                    }
                } case 'r' -> {
                    if (handleCorrectAnswer('4', question.getIndexOfCorrectAnswer())) {
                        player2.setCorrectQuestions();
                    }
                }
            }

            numberOfAnsweredQuestions++;
            indexOfQuestion++;
            if(indexOfQuestion >=  gameMode.getCategories().get(0).getQuestions().size()){
                gameMode.setCategories(randomize(gameMode.getCategories()));
                indexOfQuestion = 0;
            }
        }
        gameScreen.displayMode3Results(player1, player2);
        GameScreenControl.setActualScreen("results");
    }

    public boolean handleCorrectAnswer(char scannedCharacter, int indexOfCorrectAnswer){        //handling scanned character and correct answer
        return (Character.getNumericValue(scannedCharacter) - 1) == indexOfCorrectAnswer;
    }
}
