package team1.project3;

import team1.project3.service.IViewController;
import team1.project3.utils.UiUtil;

import javax.swing.*;

public class StudentApp {

    private static JFrame mainFrame = new JFrame("Student App");

    public static void main(String[] args) {
        navigate(UiUtil.getUIComponent("1", null));
    }

    public static void navigate(final IViewController targetVC) {
        if (targetVC != null) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    StudentApp.mainFrame.getContentPane().removeAll();
                    StudentApp.mainFrame.getContentPane().add(targetVC.getRootComponent());
                    StudentApp.mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    StudentApp.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    StudentApp.mainFrame.setVisible(true);
                }
            });
        }
    }
}

