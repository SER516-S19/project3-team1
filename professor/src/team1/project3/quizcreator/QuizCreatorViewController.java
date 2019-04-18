package team1.project3.quizcreator;

import team1.project3.factories.QuizFactory;
import team1.project3.service.IModel;
import team1.project3.service.IView;
import team1.project3.service.IViewController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The {@code QuizCreatorViewController} represents the view controller for the Quiz Creation
 */
public class QuizCreatorViewController implements IViewController {
    private QuizCreatorView quizCreatorView;
    private QuizCreatorModel quizCreatorModel;
    private int questionNumber;

    private ActionListener OptionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String option = e.getActionCommand();

            quizCreatorView.getAnswerInput1().setForeground((option.equals("A")) ? Color.GREEN : Color.RED);
            quizCreatorView.getAnswerInput2().setForeground((option.equals("B")) ? Color.GREEN : Color.RED);
            quizCreatorView.getAnswerInput3().setForeground((option.equals("C")) ? Color.GREEN : Color.RED);
            quizCreatorView.getAnswerInput4().setForeground((option.equals("D")) ? Color.GREEN : Color.RED);
        }
    };

     /**
     * Validates if all the fields are entered for a question to be added, saves the current question data
     * and initialises the frame to input the next question
     */
    private ActionListener nextButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!isValidQuestion()) {
                JOptionPane.showMessageDialog(null,
                        "Please fill in all the fields");
            } else {
                saveCurrentQuestion();
                initializeQuestionFrame();
            }
        }
    };

    /**
     * Checks for validation and saves the current question data.
     */
    private ActionListener saveButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!isValidQuestion()) {
                JOptionPane.showMessageDialog(null,
                        "Please fill in all the fields");
            } else {
                saveCurrentQuestion();
                String quizName = JOptionPane.showInputDialog("Enter quiz name");
                try {
                    QuizFactory.writeQuizToFile(quizCreatorModel.getQuiz(),
                            "Resources/" + quizName + ".json");
                    JOptionPane.showMessageDialog(null, "Quiz successfully saved!");
                    prepareUIForNewQuiz();
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "Error in saving quiz!");
                }
            }
        }
    };

    public QuizCreatorViewController(QuizCreatorView quizCreatorView, QuizCreatorModel quizCreatorModel) {
        this.quizCreatorView = quizCreatorView;
        this.quizCreatorModel = quizCreatorModel;

        quizCreatorView.getOptionA().addActionListener(OptionListener);
        quizCreatorView.getOptionB().addActionListener(OptionListener);
        quizCreatorView.getOptionC().addActionListener(OptionListener);
        quizCreatorView.getOptionD().addActionListener(OptionListener);

        quizCreatorView.getNextButton().addActionListener(nextButtonListener);
        quizCreatorView.getSaveButton().addActionListener(saveButtonListener);

        questionNumber = 1;
    }

    /**
     * Validates if all the fields are entered for a question to be added
     */
    private boolean isValidQuestion() {
        return (quizCreatorView.getOptionA().isSelected()
                || quizCreatorView.getOptionB().isSelected()
                || quizCreatorView.getOptionC().isSelected()
                || quizCreatorView.getOptionD().isSelected())
                && !quizCreatorView.getAnswerInput1().getText().equals("")
                && !quizCreatorView.getAnswerInput2().getText().equals("")
                && !quizCreatorView.getAnswerInput3().getText().equals("")
                && !quizCreatorView.getAnswerInput4().getText().equals("")
                && !quizCreatorView.getQuestionInput().getText().equals("");
    }

    private void prepareUIForNewQuiz() {
        questionNumber = 1;
        quizCreatorView.getQuestionNumberLabel().setText("Question " + questionNumber);
        clearTextBoxes();
        resetSelectionOnRadioButtons();
    }

    /**
     * Calls the relevant functions for clearing form fields.
     */
    private void initializeQuestionFrame() {
        clearTextBoxes();
        incrementQuestionNumber();
        resetSelectionOnRadioButtons();
    }

    private void incrementQuestionNumber() {
        questionNumber++;
        quizCreatorView.getQuestionNumberLabel().setText("Question " + questionNumber);
    }

    private void resetSelectionOnRadioButtons() {
        quizCreatorView.getOptionsGroup().clearSelection();
        quizCreatorView.getAnswerInput1().setForeground(Color.black);
        quizCreatorView.getAnswerInput2().setForeground(Color.black);
        quizCreatorView.getAnswerInput3().setForeground(Color.black);
        quizCreatorView.getAnswerInput4().setForeground(Color.black);
    }


    private void clearTextBoxes() {
        quizCreatorView.getAnswerInput1().setText("");
        quizCreatorView.getAnswerInput2().setText("");
        quizCreatorView.getAnswerInput3().setText("");
        quizCreatorView.getAnswerInput4().setText("");
        quizCreatorView.getQuestionInput().setText("");
    }

    private void saveCurrentQuestion() {
        List<String> options = new ArrayList<String>();
        options.add(quizCreatorView.getAnswerInput1().getText());
        options.add(quizCreatorView.getAnswerInput2().getText());
        options.add(quizCreatorView.getAnswerInput3().getText());
        options.add(quizCreatorView.getAnswerInput4().getText());
        String questionTitle = quizCreatorView.getQuestionInput().getText();
        quizCreatorModel.saveQuestion(questionTitle, options, getSelectedOptionText());
    }

    private String getSelectedOptionText() {
        String selectedOption;
        if (quizCreatorView.getOptionA().isSelected()) {
            selectedOption = quizCreatorView.getAnswerInput1().getText();
        } else if (quizCreatorView.getOptionB().isSelected()) {
            selectedOption = quizCreatorView.getAnswerInput2().getText();
        } else if (quizCreatorView.getOptionC().isSelected()) {
            selectedOption = quizCreatorView.getAnswerInput3().getText();
        } else if (quizCreatorView.getOptionD().isSelected()) {
            selectedOption = quizCreatorView.getAnswerInput4().getText();
        } else {
            selectedOption = null;
        }
        return selectedOption;
    }

    @Override
    public JComponent getRootComponent() {
        return quizCreatorView.$$$getRootComponent$$$();
    }

    @Override
    public void initializeViewController(IView view, IModel model, HashMap<String, String> params) {
        this.quizCreatorView = (QuizCreatorView) view;
        this.quizCreatorModel = (QuizCreatorModel) model;
    }
}
