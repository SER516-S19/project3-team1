import javax.swing.*;



public class ProfessorApp {
    public static void main(String[] args) {
        ProfessorModel professorModel = new ProfessorModel("Quiz1.json");
        ProfessorView professorView = new ProfessorView();
        ProfessorViewController professorViewController = new ProfessorViewController(professorView, professorModel);

    }
}
