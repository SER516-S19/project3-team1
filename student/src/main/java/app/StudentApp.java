package main.java.app;

import main.java.quiz.StudentModel;
import main.java.quiz.StudentView;
import main.java.quiz.StudentViewController;

import javax.swing.*;

public class StudentApp {
    public static void main(String[] args) {
            StudentModel studentModel = new StudentModel("Quiz1.json");
            StudentView studentView = new StudentView();
            StudentViewController studentViewController= new StudentViewController(studentView, studentModel);
    }
}
