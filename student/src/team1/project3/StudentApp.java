package team1.project3;

import team1.project3.quizlist.QuizListViewController;
import team1.project3.service_implementation.NavigationService;

import javax.swing.*;

public class StudentApp {

    public static JFrame mainFrame = new JFrame("Student App");

    public static void main(String[] args) {
        NavigationService.getInstance().navigate(QuizListViewController.class, null);
    }
}

