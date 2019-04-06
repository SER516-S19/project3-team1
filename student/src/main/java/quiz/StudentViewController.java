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
        loadQuizTitle(currentQuestionIndex);
        loadOptions(currentQuestionIndex);
        loadQuestionNumber(currentQuestionIndex);
    }

    private void loadOptions(int currentQuestionIndex) {

        studentView.getchoiceALabel().setText(studentModel.getQuiz().questions.get(currentQuestionIndex).getOptions().get(0));
        studentView.getchoiceBLabel().setText(studentModel.getQuiz().questions.get(currentQuestionIndex).getOptions().get(1));
        studentView.getchoiceCLabel().setText(studentModel.getQuiz().questions.get(currentQuestionIndex).getOptions().get(2));
        studentView.getchoiceDLabel().setText(studentModel.getQuiz().questions.get(currentQuestionIndex).getOptions().get(3));
    }


    private void loadQuestionNumber(int currentQuestionIndex) {
        int question=currentQuestionIndex+1;
        studentView.getQuestionNumberLabel().setText("Question "+question);
    }
    private void loadQuestion(int currentQuestionIndex) {
        studentView.getQuestionTitleLabel().setText(studentModel.getQuiz().questions.get(currentQuestionIndex).getTitle());
    }

    private void loadQuizTitle(int currentQuestionIndex) {
        int quiz=currentQuestionIndex+1;
        studentView.getQuizTitleLabel().setText("Quiz "+quiz);
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


