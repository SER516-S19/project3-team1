package com.team1.project3.professorapp;

import javax.swing.*;



public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Professor App");
        frame.setContentPane(new ProfessorApp().$$$getRootComponent$$$());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
