package main.java.quizlist;

import main.java.ServiceImplementation.NavigationService;
import main.java.quiztaker.QuizTakerViewController;
import service.IModel;
import service.IView;
import service.IViewController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class QuizListViewController implements IViewController {
    private QuizListModel quizListModel;
    private QuizListView quizListView;

    public QuizListViewController(){}

    @Override
    public JComponent getRootComponent() {
        return quizListView.$$$getRootComponent$$$();
    }

    @Override
    public void initializeViewController(IView view, IModel model, HashMap<String, String> params) {
        quizListView = (QuizListView) view;
        quizListModel = (QuizListModel) model;
        registerForActionListeners();
    }

    private void registerForActionListeners() {
        quizListView.getNavigateToQuizPageButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HashMap<String, String> params = new HashMap<String, String>() {
                    {
                        put("selectedQuizName", "Quiz1.json");
                    }
                };
                NavigationService.getInstance().navigate(QuizTakerViewController.class, params);
            }
        });
    }
}
