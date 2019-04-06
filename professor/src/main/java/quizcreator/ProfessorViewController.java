package main.java.quizcreator;

import javax.swing.*;

public class ProfessorViewController {
    private ProfessorView professorView;
    private ProfessorModel professorModel;
    public ProfessorViewController(ProfessorView professorView, ProfessorModel professorModel) {
        this.professorView = professorView;
        this.professorModel = professorModel;
        initializeView();
    }

    private void initializeView() {
        JFrame frame = new JFrame("Professor");
        frame.setContentPane(professorView.$$$getRootComponent$$$());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
