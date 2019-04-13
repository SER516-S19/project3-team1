package team1.project3.quiztaker;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import team1.project3.service.IView;
import javax.swing.*;
import java.awt.*;

/**
 * Represents the student quiz view
 */
public class QuizTakerView extends JPanel implements IView {
    private JRadioButton aRadioButton;
    private JRadioButton bRadioButton;
    private JRadioButton cRadioButton;
    private JRadioButton dRadioButton;
    private JButton nextButton;
    private JButton giveUpButton;
    private JPanel panel_StudentApp;
    private JTextField choiceA;
    private JTextField choiceB;
    private JTextField choiceC;
    private JTextField choiceD;
    private JLabel quizTitle;
    private JLabel questionNumber;
    private JLabel questionTitle;
    private ButtonGroup buttonGroup1;

    JLabel getQuizTitleLabel() {
        return quizTitle;
    }

    JTextField getchoiceALabel() {
        return choiceA;
    }

    JTextField getchoiceBLabel() {
        return choiceB;
    }

    JTextField getchoiceCLabel() {
        return choiceC;
    }

    JTextField getchoiceDLabel() {
        return choiceD;
    }

    JLabel getQuestionNumberLabel() {
        return questionNumber;
    }

    JLabel getQuestionTitleLabel() {
        return questionTitle;
    }

    JButton getNextButton() {
        return nextButton;
    }

    JRadioButton getaRadioButton() {
        return aRadioButton;
    }

    JRadioButton getbRadioButton() {
        return bRadioButton;
    }

    JRadioButton getcRadioButton() {
        return cRadioButton;
    }

    JRadioButton getdRadioButton() {
        return dRadioButton;
    }

    ButtonGroup getButtonGroup() {
        return buttonGroup1;
    }

    JButton getGiveUpButton() {
        return giveUpButton;
    }

    public QuizTakerView() {
        quizTitle.setText("Quiz Title");
        questionNumber.setText("Question Number");
        questionTitle.setText("Question Title");
        choiceA.setText("choiceA");
        choiceB.setText("choiceB");
        choiceC.setText("choiceC");
        choiceD.setText("choiceD");
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel_StudentApp = new JPanel();
        panel_StudentApp.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel_StudentApp.add(panel1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        aRadioButton = new JRadioButton();
        aRadioButton.setEnabled(true);
        aRadioButton.setHideActionText(false);
        aRadioButton.setSelected(false);
        aRadioButton.setText("A");
        panel1.add(aRadioButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bRadioButton = new JRadioButton();
        bRadioButton.setText("B");
        panel1.add(bRadioButton, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cRadioButton = new JRadioButton();
        cRadioButton.setText("C");
        panel1.add(cRadioButton, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        dRadioButton = new JRadioButton();
        dRadioButton.setText("D");
        panel1.add(dRadioButton, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        choiceA = new JTextField();
        choiceA.setEditable(false);
        panel1.add(choiceA, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        choiceB = new JTextField();
        choiceB.setEditable(false);
        panel1.add(choiceB, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        choiceC = new JTextField();
        choiceC.setEditable(false);
        panel1.add(choiceC, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        choiceD = new JTextField();
        choiceD.setEditable(false);
        panel1.add(choiceD, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel_StudentApp.add(panel2, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        nextButton = new JButton();
        nextButton.setText("Next");
        panel2.add(nextButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel2.add(spacer1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        giveUpButton = new JButton();
        giveUpButton.setText("Give up");
        panel2.add(giveUpButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel_StudentApp.add(panel3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        quizTitle = new JLabel();
        quizTitle.setText("Quiz Title");
        panel3.add(quizTitle, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        panel3.add(spacer2, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        questionNumber = new JLabel();
        questionNumber.setText("QuestionNumber ");
        panel3.add(questionNumber, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        questionTitle = new JLabel();
        questionTitle.setText("QuestionTitle");
        panel3.add(questionTitle, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(dRadioButton);
        buttonGroup1.add(cRadioButton);
        buttonGroup1.add(bRadioButton);
        buttonGroup1.add(aRadioButton);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel_StudentApp;
    }

}
