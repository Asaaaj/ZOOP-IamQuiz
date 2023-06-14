package iamquiz.controller;

import iamquiz.model.Category;
import iamquiz.model.Question;
import iamquiz.view.GameScreen;

import java.io.*;
import java.util.Scanner;

public class FileHandling {
    private final String fileQuestionsName;

    public FileHandling(String name) {
        fileQuestionsName = name;
    }

    public void addQuestion(GameScreen gameScreen) {        //method for adding a question to a file
        try {
            Scanner scanner = new Scanner(System.in);
            FileWriter writer = new FileWriter(fileQuestionsName, true);

            gameScreen.displayAddQuestion();
            String question = scanner.nextLine();
            question += "\n";
            writer.append('\n');
            writer.write(question);

            gameScreen.displayAddCorrectAnswer();
            question = scanner.nextLine();
            question += "\n";
            writer.write(question);

            for (int i = 0; i < 2; i++) {
                gameScreen.displayAddIncorrectAnswer();
                question = scanner.nextLine();
                question += "\n";
                writer.write(question);
            }

            gameScreen.displayAddIncorrectAnswer();
            question = scanner.nextLine();
            writer.write(question);
            writer.close();
        }
        catch (IOException e) {
            System.out.println("Whoops");
        }
    }

    public final Category loadFile() {      //method for loading questions from a file
        Category category = new Category(fileQuestionsName);
        try (Scanner loader = new Scanner(new FileReader(fileQuestionsName))) {
            while (loader.hasNext()) {
                Question question = new Question();
                String loadedQuestion = loader.nextLine();
                question.setQuestion(loadedQuestion);
                for (int numberOfAnswer = 0; numberOfAnswer < 4; numberOfAnswer++) {
                    String loadedAnswer = loader.nextLine();
                    question.setAnswers(loadedAnswer);
                }
                category.setQuestions(question);
            }
        }
        catch (IOException e) {
            System.out.println("Whoops");
        }
        return category;
    }
}
