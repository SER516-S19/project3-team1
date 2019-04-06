package main.java.app;

import main.java.quizcreator.ProfessorModel;
import main.java.quizcreator.ProfessorView;
import main.java.quizcreator.ProfessorViewController;


public class ProfessorApp {
    public static void main(String[] args) {
        ProfessorModel professorModel = new ProfessorModel("Quiz1.json");
        ProfessorView professorView = new ProfessorView();
        ProfessorViewController professorViewController = new ProfessorViewController(professorView, professorModel);
    }
}
