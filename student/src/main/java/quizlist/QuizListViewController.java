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

    private void registerForActionListeners() {
//        quizListView.getNavigateToQuizPageButton().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                HashMap<String, String> params = new HashMap<String, String>() {
//                    {
//                        put("selectedQuizName", "Quiz1.json");
//                    }
//                };
//                NavigationService.getInstance().navigate(QuizTakerViewController.class, params);
//            }
//        });
    }



    public void setQuizNames(List<String> quizNames)
    {
        //this.quizNames=quizListModel.getQuizNames();
        this.quizNames=quizNames;
        System.out.println("quiz set"+this.quizNames);

    }

    private void buttonCreation() {
        setQuizNames(quizListModel.getQuizNames());
        List results=quizNames;
        JPanel panel= quizListView.getPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        for(int i=results.size()-1;i>=0;i--){
            System.out.println(i);
            System.out.println(results.get(i).toString());
            JButton button= new JButton();
            button.setText(results.get(i).toString());
            panel.add(button);
        }
    }

}
