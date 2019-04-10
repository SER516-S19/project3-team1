package main.java.quiztaker;

import service.IModel;
import service.IView;
import service.IViewController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class QuizTakerViewController implements IViewController {
    private QuizTakerView quizTakerView;
    private QuizTakerModel quizTakerModel;
    private int currentQuestionIndex = 0;
    public QuizTakerViewController() {}



    private void renderQuestionToFrame(){

        loadQuestion(currentQuestionIndex);
        loadQuizTitle(currentQuestionIndex);
        loadOptions(currentQuestionIndex);
        loadQuestionNumber(currentQuestionIndex);
        resetSelectionsOnRadioButtons();
    }

    private void registerActionListenersForUIComponents(){

        registerActionListenerForNextButton();
    }

    private void resetSelectionsOnRadioButtons(){

        quizTakerView.getaRadioButton().setSelected(false);
        quizTakerView.getbRadioButton().setSelected(false);
        quizTakerView.getcRadioButton().setSelected(false);
        quizTakerView.getdRadioButton().setSelected(false);

    }

    private void loadOptions(int currentQuestionIndex) {

        quizTakerView.getchoiceALabel().setText(quizTakerModel.getQuiz().getQuestions().get(currentQuestionIndex).getOptions().get(0));
        quizTakerView.getchoiceBLabel().setText(quizTakerModel.getQuiz().getQuestions().get(currentQuestionIndex).getOptions().get(1));
        quizTakerView.getchoiceCLabel().setText(quizTakerModel.getQuiz().getQuestions().get(currentQuestionIndex).getOptions().get(2));
        quizTakerView.getchoiceDLabel().setText(quizTakerModel.getQuiz().getQuestions().get(currentQuestionIndex).getOptions().get(3));
    }


    private void loadQuestionNumber(int currentQuestionIndex) {
        int question=currentQuestionIndex+1;
        quizTakerView.getQuestionNumberLabel().setText("Question "+question);
    }
    private void loadQuestion(int currentQuestionIndex) {
        quizTakerView.getQuestionTitleLabel().setText(quizTakerModel.getQuiz().getQuestions().get(currentQuestionIndex).getTitle());
    }

    private void loadQuizTitle(int currentQuestionIndex) {
        int quiz=currentQuestionIndex+1;
        quizTakerView.getQuizTitleLabel().setText("Quiz "+quiz);
    }


    private void registerActionListenerForNextButton(){

        quizTakerView.getNextButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evaluateAnswerAndLoadNextQuestion();
            }
        });
    }
    private void evaluateAnswerAndLoadNextQuestion(){

        int selectedOptionIndex = 0;
        if(quizTakerView.getaRadioButton().isSelected()){
            selectedOptionIndex=0;
        }
        else if(quizTakerView.getbRadioButton().isSelected()){
            selectedOptionIndex=1;
        }
        else if(quizTakerView.getcRadioButton().isSelected()){
            selectedOptionIndex=2;
        }
        else{
            selectedOptionIndex=3;
        }
        quizTakerModel.evaluateAnswer(currentQuestionIndex,selectedOptionIndex);

        if (currentQuestionIndex < quizTakerModel.getQuiz().getQuestions().size()-1)
            currentQuestionIndex+=1;
        else
            currentQuestionIndex=0;

        renderQuestionToFrame();
    }


    @Override
    public JComponent getRootComponent() {
        return quizTakerView.$$$getRootComponent$$$();
    }

    @Override
    public void initializeViewController(IView view, IModel model, HashMap<String, String> params) {
        quizTakerView = (QuizTakerView) view;
        quizTakerModel = (QuizTakerModel) model;
        if (params != null && params.containsKey("selectedQuizName")) {
            quizTakerModel.loadQuiz(params.get("selectedQuizName"));
        }
        renderQuestionToFrame();
        registerActionListenersForUIComponents();
    }
}


