package main.java.quizcreator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import java.util.ArrayList;
import java.util.List;


public class ProfessorViewController
    {
        private ProfessorView professorView;
        private ProfessorModel professorModel;

        private int questionNumber;

        public ProfessorViewController(ProfessorView professorView, ProfessorModel professorModel) {
        this.professorView = professorView;
        this.professorModel = professorModel;
        initializeView();
        OptionAListener();
        OptionBListener();
        OptionCListener();
        OptionDListener();
        answerInput1Listener();
        answerInput2Listener();
        answerInput3Listener();
        answerInput4Listener();
        nextButtonListener();
        questionNumber = 1;

    }

    private void initializeQuestionFrame() {
        clearTextBoxes();
        incrementQuestionNumber();
        resetSelectionOnRadioButtons();
    }

    private void incrementQuestionNumber() {
            questionNumber++;
            //professorView.getLabel1().setText("Question " + (questionNumber));
    }


        private void resetSelectionOnRadioButtons()
        {
            professorView.getButtonGroup().clearSelection();
        }

        private void clearTextBoxes() {
            professorView.getAnswerInput1().setText("");
            professorView.getAnswerInput2().setText("");
            professorView.getAnswerInput3().setText("");
            professorView.getAnswerInput4().setText("");
            professorView.getQuestionInput().setText("");
        }


    private void OptionAListener()
    {

        professorView.getOptionA().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                professorView.getAnswerInput1().setForeground(Color.GREEN);
                professorView.getAnswerInput2().setForeground(Color.RED);
                professorView.getAnswerInput3().setForeground(Color.RED);
                professorView.getAnswerInput4().setForeground(Color.RED);
            }
        });
    }
    private void OptionBListener()
    {
        professorView.getOptionB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                professorView.getAnswerInput2().setForeground(Color.GREEN);
                professorView.getAnswerInput1().setForeground(Color.RED);
                professorView.getAnswerInput3().setForeground(Color.RED);
                professorView.getAnswerInput4().setForeground(Color.RED);
            }
        });
    }
    private void OptionCListener()
    {
        professorView.getOptionC().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                professorView.getAnswerInput3().setForeground(Color.GREEN);
                professorView.getAnswerInput2().setForeground(Color.RED);
                professorView.getAnswerInput1().setForeground(Color.RED);
                professorView.getAnswerInput4().setForeground(Color.RED);
            }
        });
    }
    private void OptionDListener()
    {
        professorView.getOptionD().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                professorView.getAnswerInput4().setForeground(Color.GREEN);
                professorView.getAnswerInput2().setForeground(Color.RED);
                professorView.getAnswerInput3().setForeground(Color.RED);
                professorView.getAnswerInput1().setForeground(Color.RED);
            }
        });
    }
    private void answerInput1Listener()
    {
        professorView.getAnswerInput1().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                professorView.getAnswerInput1().setText("");
            }
        });
    }
    private void answerInput2Listener()
    {
        professorView.getAnswerInput2().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                professorView.getAnswerInput2().setText("");
            }
        });
    }
    private void answerInput3Listener()
    {
        professorView.getAnswerInput3().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                professorView.getAnswerInput3().setText("");
            }
        });
    }
    private void answerInput4Listener()
    {
        professorView.getAnswerInput4().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                professorView.getAnswerInput4().setText("");
            }
        });
    }
    private void nextButtonListener()
    {
        professorView.getNextButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (professorView.getOptionA().isSelected() == false && professorView.getOptionB().isSelected() == false
                        && professorView.getOptionC().isSelected() == false && professorView.getOptionD().isSelected() == false){
                    JOptionPane.showMessageDialog(null,
                            "Please select at lease one correct answer");
                } else {
                    saveCurrentQuestion();
                }

            }

        });
    }
    private void initializeView()
    {
        JFrame frame = new JFrame("Professor");
        frame.setContentPane(professorView.$$$getRootComponent$$$());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void saveCurrentQuestion() {
        List<String> options = new ArrayList<String>();
        options.add(professorView.getAnswerInput1().getText());
        options.add(professorView.getAnswerInput2().getText());
        options.add(professorView.getAnswerInput3().getText());
        options.add(professorView.getAnswerInput4().getText());
        String questionTitle = professorView.getQuestionInput().getText();
        professorModel.saveQuestion(questionTitle, options, "");

        initializeQuestionFrame();

    }

}

