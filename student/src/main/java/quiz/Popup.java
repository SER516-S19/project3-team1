package main.java.quiz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Popup extends JFrame  {
    private JFrame popup = new JFrame();
    private JButton okay = new JButton();
    Popup(int param)
    {
        if(param!=0)
        {
            JOptionPane.showMessageDialog(popup, "NUMBER OF INCORRECT ANSWERS:"+param+"\n");
            okay.setText("OK");
            okay.setVisible(true);
            popup.add(okay);
            okay.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    popup.setVisible(false);
                }
            });
        }

        else
        {
            JOptionPane.showMessageDialog(popup, "YOU MADE IT! \ud83d\udc6f \n");
            okay.setText("OK");
            okay.setVisible(true);
            popup.add(okay);
            okay.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    popup.setVisible(false);
                }
            });
        }




    }

}
