package iamquiz.model;

import java.util.ArrayList;

public class  GameMode {
    private String gameModeName;
    private int numberOfQuestions = 20;
    private int numberOfAnsweredQuestions = 1;
    private final int  defaultLife = 5;
    private final int defaultTime = 5;
    private ArrayList<Category> categories = new ArrayList<>();

    public GameMode() {
        gameModeName = "undefined";
    }

    public int getDefaultTime() {
        return defaultTime;
    }

    public int getNumberOfAnsweredQuestions() {
        return numberOfAnsweredQuestions;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public int getDefaultLife() {
        return defaultLife;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setGameModeName(String gameModeName) {
        this.gameModeName = gameModeName;
    }
}
