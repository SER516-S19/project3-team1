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


import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class QuizListViewController implements IViewController {
    private QuizListModel quizListModel;
    private QuizListView quizListView;
    private List<String> quizNames = new ArrayList<String>();

    public QuizListViewController(){
    }

    @Override
    public JComponent getRootComponent() {
        return quizListView.$$$getRootComponent$$$();
    }

    @Override
    public void initializeViewController(IView view, IModel model, HashMap<String, String> params) {
        quizListView = (QuizListView) view;
        quizListModel = (QuizListModel) model;
        buttonCreation();
        registerForActionListeners();
    }

    private void registerForActionListeners()
    {


    }

    public void setQuizNames(List<String> quizNames)
    {
        this.quizNames=quizNames;
    }

    private void buttonCreation() {
        setQuizNames(quizListModel.getQuizNames());
        List results=quizNames;
        JPanel panel= quizListView.getPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        for(int i=results.size()-1;i>=0;i--){
            JButton button= new JButton();
            button.setText(results.get(i).toString());
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    HashMap<String, String> params = new HashMap<String, String>() {
                        {
                            put("selectedQuizName", ((JButton) e.getSource()).getText());
                        }
                    };
                    NavigationService.getInstance().navigate(QuizTakerViewController.class, params);
                }
            });
            panel.add(button);
        }
    }
}
