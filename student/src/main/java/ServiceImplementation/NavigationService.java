package main.java.ServiceImplementation;

import main.java.app.StudentApp;
import main.java.factories.UIFactory;
import service.INavigationService;
import service.IViewController;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;


public class NavigationService implements INavigationService {


    private static NavigationService navigationService = new NavigationService();

    private NavigationService() {}

    public static NavigationService getInstance() {
        return navigationService;
    }

    @Override
    public <T> void navigate(Class<T> viewControllerType, HashMap<String, String> params) {

        try {
            final IViewController viewController = UIFactory.generateComponent(viewControllerType, params);
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    StudentApp.mainFrame.getContentPane().removeAll();
                    StudentApp.mainFrame.getContentPane().add(viewController.getRootComponent());
                    StudentApp.mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    StudentApp.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    StudentApp.mainFrame.setVisible(true);
                }
            });
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
