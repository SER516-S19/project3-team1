import javax.swing.*;

public class StudentApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student StudentApp");
        frame.setContentPane(new main.java.StudentView().$$$getRootComponent$$$());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
