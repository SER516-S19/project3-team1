package com.team1.project3.studentapp;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student App");
        frame.setContentPane(new StudentApp().$$$getRootComponent$$$());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
