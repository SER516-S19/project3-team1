package team1.project3.service;

import javax.swing.*;
import java.util.HashMap;

/**
 * The base view controller interface
 */
public interface IViewController {
    /**
     * @return the container component of the view
     */
    JComponent getRootComponent();

    /**
     * initializes the view controller with
     * @param view represents the UI view
     * @param model represents the model for the view controller
     * @param params represents the view controller initialization params
     */
    void initializeViewController(IView view, IModel model, HashMap<String, String> params);
}
