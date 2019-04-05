import javax.swing.*;



public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Professor App");
        frame.setContentPane(new ProfessorView().$$$getRootComponent$$$());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
