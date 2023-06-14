package iamquiz.model;

import java.util.ArrayList;

public class Question {
    private String question;
    private int indexOfCorrectAnswer = 0;
    private final ArrayList<String> answers = new ArrayList<>();


    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(String answer) {
        answers.add(answer);
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getIndexOfCorrectAnswer() {
        return indexOfCorrectAnswer;
    }

    public void setIndexOfCorrectAnswer(int indexOfCorrectAnswer) {
        this.indexOfCorrectAnswer = indexOfCorrectAnswer;
    }
}
