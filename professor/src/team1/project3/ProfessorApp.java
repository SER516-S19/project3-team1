package team1.project3;

import team1.project3.quizcreator.QuizCreatorModel;
import team1.project3.quizcreator.QuizCreatorView;
import team1.project3.quizcreator.QuizCreatorViewController;


public class ProfessorApp {
    public static void main(String[] args) {
        QuizCreatorModel quizCreatorModel = new QuizCreatorModel("Quiz1.json");
        QuizCreatorView quizCreatorView = new QuizCreatorView();
        QuizCreatorViewController quizCreatorViewController = new QuizCreatorViewController(quizCreatorView, quizCreatorModel);
    }
}
