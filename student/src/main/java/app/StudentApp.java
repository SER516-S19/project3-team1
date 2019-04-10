package main.java.app;


import main.java.ServiceImplementation.NavigationService;
import main.java.quizlist.QuizListViewController;

import javax.swing.*;
import java.util.HashMap;

public class StudentApp {

    public static JFrame mainFrame = new JFrame("Student App");

    public static void main(String[] args) {
        NavigationService.getInstance().navigate(QuizListViewController.class, null);
    }
}




