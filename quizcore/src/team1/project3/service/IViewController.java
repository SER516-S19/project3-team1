package team1.project3.service;

import javax.swing.*;
import java.util.HashMap;

public interface IViewController {
    void initializeViewController(IView view, IModel model, HashMap<String, String> params);
}
