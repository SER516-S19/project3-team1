package main.java.quiz;

import javax.swing.*;

public class StudentViewController {
    private StudentView studentView;
    private StudentModel studentModel;
    private int currentQuestionIndex = 0;
    public StudentViewController(StudentView studentView, StudentModel studentModel) {
        this.studentView = studentView;
        this.studentModel = studentModel;
        initializeView();
        loadQuestion(currentQuestionIndex);
    }

    private void loadQuestion(int currentQuestionIndex) {
        studentView.getQuizTitleLabel().setText(studentModel.getQuiz().questions.get(currentQuestionIndex).getTitle());
    }

    private void initializeView() {
        JFrame frame = new JFrame("Student");
        frame.setContentPane(studentView.$$$getRootComponent$$$());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }





}


