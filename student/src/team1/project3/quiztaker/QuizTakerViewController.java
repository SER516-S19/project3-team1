package team1.project3.quiztaker;

import team1.project3.quizlist.QuizListViewController;
import team1.project3.quiztaker.QuizTakerModel;
import team1.project3.quiztaker.QuizTakerView;
import team1.project3.service.IModel;
import team1.project3.service.IView;
import team1.project3.service.IViewController;
import team1.project3.service_implementation.NavigationService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


public class QuizTakerViewController implements IViewController {
    private QuizTakerView quizTakerView;
    private QuizTakerModel quizTakerModel;
    private int currentQuestionIndex = 0;

    private void renderQuestionToFrame() {
        loadQuestion(currentQuestionIndex);
        loadOptions(currentQuestionIndex);
        loadQuestionNumber(currentQuestionIndex);
        resetSelectionsOnRadioButtons();
        setTextForNext();
    }

    /**
     * This method is responsible for displaying Submit button while displaying the last question otherwise having the
     * button display Next.
     */
    private void setTextForNext() {
        if (currentQuestionIndex == quizTakerModel.getQuiz().getQuestions().size() - 1)
            quizTakerView.getNextButton().setText("Submit");
        else
            quizTakerView.getNextButton().setText("Next");

    }

    private void registerActionListenersForUIComponents() {
        registerActionListenerForGiveUpButton();
        registerActionListenerForNextButton();
    }

    private void registerActionListenerForGiveUpButton() {
        quizTakerView.getGiveUpButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NavigationService.getInstance().navigate(QuizListViewController.class, null);
            }
        });
    }

    private void resetSelectionsOnRadioButtons() {

        quizTakerView.getButtonGroup().clearSelection();

    }

    private void loadOptions(int currentQuestionIndex) {

        quizTakerView.getchoiceALabel().setText(quizTakerModel.getQuiz().getQuestions().get(currentQuestionIndex).getOptions().get(0));
        quizTakerView.getchoiceBLabel().setText(quizTakerModel.getQuiz().getQuestions().get(currentQuestionIndex).getOptions().get(1));
        quizTakerView.getchoiceCLabel().setText(quizTakerModel.getQuiz().getQuestions().get(currentQuestionIndex).getOptions().get(2));
        quizTakerView.getchoiceDLabel().setText(quizTakerModel.getQuiz().getQuestions().get(currentQuestionIndex).getOptions().get(3));
    }


    private void loadQuestionNumber(int currentQuestionIndex) {
        int question = currentQuestionIndex + 1;
        quizTakerView.getQuestionNumberLabel().setText("Question " + question);
    }

    private void loadQuestion(int currentQuestionIndex) {
        quizTakerView.getQuestionTitleLabel().setText(quizTakerModel.getQuiz().getQuestions().get(currentQuestionIndex).getTitle());
    }

    private void loadQuizTitle(String quizTitle) {
        quizTakerView.getQuizTitleLabel().setText(quizTitle);
    }


    private void registerActionListenerForNextButton() {

        quizTakerView.getNextButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                evaluateAnswerAndLoadNextQuestion();
            }
        });
    }

    private void evaluateAnswerAndLoadNextQuestion() {

        int selectedOptionIndex;
        if (quizTakerView.getaRadioButton().isSelected()) {
            selectedOptionIndex = 0;
        } else if (quizTakerView.getbRadioButton().isSelected()) {
            selectedOptionIndex = 1;
        } else if (quizTakerView.getcRadioButton().isSelected()) {
            selectedOptionIndex = 2;
        } else if (quizTakerView.getdRadioButton().isSelected()){
            selectedOptionIndex = 3;
        }
        else{
            selectedOptionIndex = -1;
        }

        quizTakerModel.evaluateAnswer(currentQuestionIndex, selectedOptionIndex);

        if (currentQuestionIndex == quizTakerModel.getQuiz().getQuestions().size() - 1) {
            showResultPopup();
        } else {

            currentQuestionIndex += 1;
            renderQuestionToFrame();
        }

    }

    private void showResultPopup() {
        String message = "";
        if (this.quizTakerModel.getIncorrectQuestionsIndex().size() > 0) {
            message = "Number of incorrect Answers : " +
                    this.quizTakerModel.getIncorrectQuestionsIndex().size() +
                    "\nPress OK to re-attempt";
        } else {
            message = "YOU MADE IT..!";
        }
        int result = JOptionPane.showOptionDialog(null, message, "Quiz Result",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

        if (result == 0) {
            if (this.quizTakerModel.getIncorrectQuestionsIndex().size() > 0)
                initiateQuizForIncorrectQuestions();
            else {
                NavigationService.getInstance().navigate(QuizListViewController.class, null);
            }
        }


    }

    private void initiateQuizForIncorrectQuestions() {

        quizTakerModel.prepareQuizWithIncorrectAnswers();
        currentQuestionIndex = 0;
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
        if (params != null) {
            if (params.containsKey("selectedQuizName")) {
                quizTakerModel.loadQuiz(params.get("selectedQuizName"));
            }
            if (params.containsKey("quizTitle")) {
                loadQuizTitle(params.get("quizTitle"));
            }
        }

        renderQuestionToFrame();
        registerActionListenersForUIComponents();
    }
}


