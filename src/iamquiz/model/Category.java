package iamquiz.model;

import java.util.ArrayList;

public class Category {
    private final String categoryName;
    private ArrayList<Question> questions = new ArrayList<>();

    public Category(String categoryName) {

        this.categoryName = categoryName;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Question question) {
        questions.add(question);
    }
}
