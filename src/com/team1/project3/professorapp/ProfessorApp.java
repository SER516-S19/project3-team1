package com.team1.project3.professorapp;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ProfessorApp extends JFrame {
    public JPanel panel_ProfessorApp;
    private JTextArea QuestionInput;
    private JButton nextButton;
    private JButton saveButton;
    private JTextField answerInput1;
    private JTextField answerInput2;
    private JTextField answerInput3;
    private JTextField answerInput4;
    private JRadioButton OptionA;
    private JRadioButton OptionB;
    private JRadioButton OptionC;
    private JRadioButton OptionD;

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    public ProfessorApp() {
        answerInput1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                answerInput1.setText("");
            }
        });
        answerInput2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                answerInput2.setText("");
            }
        });
        answerInput3.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                answerInput3.setText("");
            }
        });
        answerInput4.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                answerInput4.setText("");
            }
        });


        OptionA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerInput1.setForeground(Color.GREEN);
                answerInput2.setForeground(Color.RED);
                answerInput3.setForeground(Color.RED);
                answerInput4.setForeground(Color.RED);
            }
        });
        OptionB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerInput2.setForeground(Color.GREEN);
                answerInput1.setForeground(Color.RED);
                answerInput3.setForeground(Color.RED);
                answerInput4.setForeground(Color.RED);
            }
        });
        OptionC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerInput3.setForeground(Color.GREEN);
                answerInput1.setForeground(Color.RED);
                answerInput2.setForeground(Color.RED);
                answerInput4.setForeground(Color.RED);
            }
        });
        OptionD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerInput4.setForeground(Color.GREEN);
                answerInput1.setForeground(Color.RED);
                answerInput2.setForeground(Color.RED);
                answerInput3.setForeground(Color.RED);
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(OptionA.isSelected()==false && OptionB.isSelected()==false
                        && OptionC.isSelected()==false && OptionD.isSelected()==false)
                    JOptionPane.showMessageDialog(null,
                            "Please select at lease one correct answer");
            }
        });
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel_ProfessorApp = new JPanel();
        panel_ProfessorApp.setLayout(new GridLayoutManager(4, 1, new Insets(0, 0, 0, 0), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel_ProfessorApp.add(panel1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Enter the Question");
        panel1.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        QuestionInput = new JTextArea();
        QuestionInput.setText("");
        QuestionInput.setOpaque(true);
        QuestionInput.setBackground(Color.LIGHT_GRAY);
        QuestionInput.setToolTipText("Enter the question here");
        panel_ProfessorApp.add(QuestionInput, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel_ProfessorApp.add(panel2, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        answerInput1 = new JTextField("Enter option 1");
        panel2.add(answerInput1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        answerInput2 = new JTextField("Enter option 2");
        panel2.add(answerInput2, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        answerInput3 = new JTextField("Enter option 3");
        panel2.add(answerInput3, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        answerInput4 = new JTextField("Enter option 4");
        panel2.add(answerInput4, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        ButtonGroup group = new ButtonGroup();
        OptionA = new JRadioButton();
        group.add(OptionA);
        panel2.add(OptionA, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        OptionB = new JRadioButton();
        group.add(OptionB);
        panel2.add(OptionB, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        OptionC = new JRadioButton();
        group.add(OptionC);
        panel2.add(OptionC, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        OptionD = new JRadioButton();
        group.add(OptionD);
        panel2.add(OptionD, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel_ProfessorApp.add(panel3, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        nextButton = new JButton();
        nextButton.setText("Next");
        panel3.add(nextButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel3.add(spacer1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        saveButton = new JButton();
        saveButton.setText("Save");
        panel3.add(saveButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel_ProfessorApp;
    }

}
