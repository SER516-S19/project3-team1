package main.java.app;

import main.java.quiz.StudentView;

import javax.swing.*;

public class StudentApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student App");
        frame.setContentPane(new StudentView().$$$getRootComponent$$$());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
