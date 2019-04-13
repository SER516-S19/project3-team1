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
        public ProfessorViewController(ProfessorView professorView, ProfessorModel professorModel) {
        this.professorView = professorView;
        this.professorModel = professorModel;
        initializeView();
        OptionAListener();
        OptionBListener();
        OptionCListener();
        OptionDListener();
        nextButtonListener();
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
    private void nextButtonListener()
    {
        professorView.getNextButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (professorView.getOptionA().isSelected() == false && professorView.getOptionB().isSelected() == false
                        && professorView.getOptionC().isSelected() == false && professorView.getOptionD().isSelected() == false){
                    JOptionPane.showMessageDialog(null,
                            "Please select at lease one correct answer");
                }else {
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

    }

}

