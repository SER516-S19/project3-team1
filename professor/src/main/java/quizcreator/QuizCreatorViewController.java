package main.java.quizcreator;

import json.QuizAccessor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code QuizCreatorViewController} represents the view controller for the Quiz Creation
 */
public class QuizCreatorViewController {
    private QuizCreatorView quizCreatorView;
    private QuizCreatorModel quizCreatorModel;
    private int questionNumber;

    public QuizCreatorViewController(QuizCreatorView quizCreatorView, QuizCreatorModel quizCreatorModel) {
        this.quizCreatorView = quizCreatorView;
        this.quizCreatorModel = quizCreatorModel;
        initializeView();
        OptionAListener();
        OptionBListener();
        OptionCListener();
        OptionDListener();
        nextButtonListener();
        saveButtonListener();
        questionNumber = 1;
    }

    /**
     *
     */
    private void saveButtonListener() {
        quizCreatorView.getSaveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if (!isValidQuestion()) {
                JOptionPane.showMessageDialog(null,
                        "Please fill in all the fields");
            } else {
                saveCurrentQuestion();
                String quizName = JOptionPane.showInputDialog("Enter quiz name");
                try {
                    QuizAccessor.writeQuizToFile(quizCreatorModel.getQuiz(),
                            "Resources/" + quizName + ".json");
                    JOptionPane.showMessageDialog(null, "Quiz successfully saved!");
                    prepareUIForNewQuiz();
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "Error in saving quiz!");
                }
            }
            }
        });
    }

    private boolean isValidQuestion() {
        return (quizCreatorView.getOptionA().isSelected()
                || quizCreatorView.getOptionB().isSelected()
                || quizCreatorView.getOptionC().isSelected()
                || quizCreatorView.getOptionD().isSelected())
                && !quizCreatorView.getAnswerInput1().getText().equals("")
                && !quizCreatorView.getAnswerInput2().getText().equals("")
                && !quizCreatorView.getAnswerInput3().getText().equals("")
                && !quizCreatorView.getAnswerInput4().getText().equals("");
    }

    private void prepareUIForNewQuiz() {
        questionNumber = 1;
        quizCreatorView.getQuestionNumberLabel().setText("Question " + questionNumber);
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

    private void OptionAListener() {
        quizCreatorView.getOptionA().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quizCreatorView.getAnswerInput1().setForeground(Color.GREEN);
                quizCreatorView.getAnswerInput2().setForeground(Color.RED);
                quizCreatorView.getAnswerInput3().setForeground(Color.RED);
                quizCreatorView.getAnswerInput4().setForeground(Color.RED);
            }
        });
    }

    private void OptionBListener() {
        quizCreatorView.getOptionB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quizCreatorView.getAnswerInput2().setForeground(Color.GREEN);
                quizCreatorView.getAnswerInput1().setForeground(Color.RED);
                quizCreatorView.getAnswerInput3().setForeground(Color.RED);
                quizCreatorView.getAnswerInput4().setForeground(Color.RED);
            }
        });
    }

    private void OptionCListener() {
        quizCreatorView.getOptionC().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quizCreatorView.getAnswerInput3().setForeground(Color.GREEN);
                quizCreatorView.getAnswerInput2().setForeground(Color.RED);
                quizCreatorView.getAnswerInput1().setForeground(Color.RED);
                quizCreatorView.getAnswerInput4().setForeground(Color.RED);
            }
        });
    }

    private void OptionDListener() {
        quizCreatorView.getOptionD().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quizCreatorView.getAnswerInput4().setForeground(Color.GREEN);
                quizCreatorView.getAnswerInput2().setForeground(Color.RED);
                quizCreatorView.getAnswerInput3().setForeground(Color.RED);
                quizCreatorView.getAnswerInput1().setForeground(Color.RED);
            }
        });
    }

    private void nextButtonListener() {
        quizCreatorView.getNextButton().addActionListener(new ActionListener() {
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

        });
    }

    private void initializeView() {
        JFrame frame = new JFrame("Professor");
        frame.setContentPane(quizCreatorView.$$$getRootComponent$$$());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
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
