package team1.project3.quizlist;

import team1.project3.ServiceImplementation.NavigationService;
import team1.project3.quiztaker.QuizTakerViewController;
import team1.project3.service.IModel;
import team1.project3.service.IView;
import team1.project3.service.IViewController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code QuizListViewController} handles the UI logic and action listeners for
 * @code QuizListView
 */
public class QuizListViewController implements IViewController {
    private QuizListModel quizListModel;
    private QuizListView quizListView;
    private List<String> quizNames = new ArrayList<String>();

    /**
     * Constructor with no parameters to create instance through {@code UIFactory}
     */
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
        loadQuizNames();
        addQuizButtonsToUi();
    }

    private void loadQuizNames()
    {
        this.quizNames = quizListModel.getQuizNames();
    }

    /**
     * On click of the button, it navigates to the quiz page passing the quiz object as a parameter
     */
    private void addQuizButtonsToUi() {
        List<String> quizNamesWithoutExtension = quizListModel.getQuizNamesWithoutExtension(quizNames);
        JPanel panel= quizListView.getPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        for(int i=quizNames.size()-1;i>=0;i--){
            JButton button= new JButton();
            button.setText(quizNamesWithoutExtension.get(i));
            button.setName(quizNames.get(i));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    HashMap<String, String> params = new HashMap<String, String>() {
                        {
                            put("selectedQuizName", ((JButton) e.getSource()).getName());
                            put("quizTitle", ((JButton) e.getSource()).getText());
                        }
                    };
                    NavigationService.getInstance().navigate(QuizTakerViewController.class, params);
                }
            });
            panel.add(button);
        }
    }
}
