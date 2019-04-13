package team1.project3;

import team1.project3.quizcreator.QuizCreatorModel;
import team1.project3.quizcreator.QuizCreatorView;
import team1.project3.quizcreator.QuizCreatorViewController;

import javax.swing.*;

public class ProfessorApp {
    public static void main(String[] args) {
        QuizCreatorModel quizCreatorModel = new QuizCreatorModel();
        QuizCreatorView quizCreatorView = new QuizCreatorView();
        QuizCreatorViewController quizCreatorViewController =
                new QuizCreatorViewController(quizCreatorView, quizCreatorModel);

        JFrame frame = new JFrame("Professor");
        frame.setContentPane(quizCreatorView.$$$getRootComponent$$$());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
