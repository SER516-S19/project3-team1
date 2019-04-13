package team1.project3.quizcreator;

import team1.project3.QuizFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class QuizCreatorViewController {
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

    private ActionListener nextButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!isOptionSelected()){
                JOptionPane.showMessageDialog(null, "Please select at lease one correct answer");
            }else {
                saveCurrentQuestion();
                initializeQuestionFrame();
            }
        }
    };

    private ActionListener saveButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!isOptionSelected()) {
                JOptionPane.showMessageDialog(null, "Please select at lease one correct answer");
            }
            else {
                saveCurrentQuestion();

                String quizName = JOptionPane.showInputDialog("Enter quiz name");
                if(quizCreatorModel.exportQuiz(quizName)) {
                    JOptionPane.showMessageDialog(null, "Quiz successfully saved!");
                    prepareUIForNewQuiz();
                }
                else {
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

    private void prepareUIForNewQuiz() {
        questionNumber = 1;
        quizCreatorView.getQuestionNumberLabel().setText("Question "+ questionNumber);
        clearTextBoxes();
        resetSelectionOnRadioButtons();
    }

    private void initializeQuestionFrame() {
        clearTextBoxes();
        incrementQuestionNumber();
        resetSelectionOnRadioButtons();
    }

    private void incrementQuestionNumber() {
        questionNumber++;
        quizCreatorView.getQuestionNumberLabel().setText("Question "+ questionNumber);
    }


    private void resetSelectionOnRadioButtons() {
        quizCreatorView.getOptionsGroup().clearSelection();
    }

    private void clearTextBoxes() {
        quizCreatorView.getAnswerInput1().setText("");
        quizCreatorView.getAnswerInput2().setText("");
        quizCreatorView.getAnswerInput3().setText("");
        quizCreatorView.getAnswerInput4().setText("");
        quizCreatorView.getQuestionInput().setText("");
    }

    private boolean isOptionSelected() {
        return quizCreatorView.getOptionA().isSelected() ||
               quizCreatorView.getOptionB().isSelected() ||
               quizCreatorView.getOptionC().isSelected() ||
               quizCreatorView.getOptionD().isSelected();
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

}

