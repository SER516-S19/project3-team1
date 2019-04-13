package team1.project3;

import team1.project3.ServiceImplementation.NavigationService;
import team1.project3.quizlist.QuizListViewController;
import javax.swing.*;

public class StudentApp {

    public static JFrame mainFrame = new JFrame("Student App");

    public static void main(String[] args) {
        NavigationService.getInstance().navigate(QuizListViewController.class, null);
    }
}

