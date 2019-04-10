package main.java.quizcreator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import java.util.ArrayList;
import java.util.List;


public class QuizCreatorViewController
    {
        private QuizCreatorView quizCreatorView;
        private QuizCreatorModel quizCreatorModel;
        public QuizCreatorViewController(QuizCreatorView quizCreatorView, QuizCreatorModel quizCreatorModel) {
        this.quizCreatorView = quizCreatorView;
        this.quizCreatorModel = quizCreatorModel;
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
    }

    private void OptionAListener()
    {

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
    private void OptionBListener()
    {
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
    private void OptionCListener()
    {
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
    private void OptionDListener()
    {
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
    private void answerInput1Listener()
    {
        quizCreatorView.getAnswerInput1().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                quizCreatorView.getAnswerInput1().setText("");
            }
        });
    }
    private void answerInput2Listener()
    {
        quizCreatorView.getAnswerInput2().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                quizCreatorView.getAnswerInput2().setText("");
            }
        });
    }
    private void answerInput3Listener()
    {
        quizCreatorView.getAnswerInput3().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                quizCreatorView.getAnswerInput3().setText("");
            }
        });
    }
    private void answerInput4Listener()
    {
        quizCreatorView.getAnswerInput4().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                quizCreatorView.getAnswerInput4().setText("");
            }
        });
    }
    private void nextButtonListener()
    {
        quizCreatorView.getNextButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (quizCreatorView.getOptionA().isSelected() == false && quizCreatorView.getOptionB().isSelected() == false
                        && quizCreatorView.getOptionC().isSelected() == false && quizCreatorView.getOptionD().isSelected() == false){
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
        quizCreatorModel.saveQuestion(questionTitle, options, "");

    }

}

