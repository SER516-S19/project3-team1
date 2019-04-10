package main.java.app;

import main.java.quizcreator.QuizCreatorModel;
import main.java.quizcreator.QuizCreatorView;
import main.java.quizcreator.QuizCreatorViewController;


public class ProfessorApp {
    public static void main(String[] args) {
        QuizCreatorModel quizCreatorModel = new QuizCreatorModel("Quiz1.json");
        QuizCreatorView quizCreatorView = new QuizCreatorView();
        QuizCreatorViewController quizCreatorViewController = new QuizCreatorViewController(quizCreatorView, quizCreatorModel);
    }
}
