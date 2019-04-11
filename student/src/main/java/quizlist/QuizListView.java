package main.java.quizlist;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import service.IView;
import javax.swing.*;
import java.awt.*;
import java.util.List;


public class QuizListView extends JPanel implements IView {
    private JPanel panel;
    private JButton navigateToQuizPageButton;

    public JButton getNavigateToQuizPageButton() {
        return navigateToQuizPageButton;
    }

    public QuizListView() {
        $$$setupUI$$$();
        buttonCreation();

    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel = new JPanel();
        panel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel.setBackground(new Color(-12510186));
        navigateToQuizPageButton = new JButton();
        navigateToQuizPageButton.setText("navigate to quiz page with Quiz1.json as param");
        panel.add(navigateToQuizPageButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

    }

    private void buttonCreation() {

        QuizListViewController qc = new QuizListViewController();
        List results=qc.getQuizNames();
        panel= new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        for(int i=results.size()-1;i>=0;i--){
            System.out.println(i);
            System.out.println(results.get(i).toString());
            JButton button= new JButton();
            button.setText(results.get(i).toString());
            panel.add(button);
        }
    }

  /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }
}
