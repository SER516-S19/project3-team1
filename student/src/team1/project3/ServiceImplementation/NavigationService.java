package team1.project3.ServiceImplementation;

import team1.project3.StudentApp;
import team1.project3.factories.UIFactory;
import team1.project3.service.INavigationService;
import team1.project3.service.IViewController;
import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * Singleton implementation to navigate from one view to another
 */
public class NavigationService implements INavigationService {

    private static NavigationService navigationService = new NavigationService();

    /**
     * private constructor to prevent object creation outside of the class
     */
    private NavigationService() {}

    public static NavigationService getInstance() {
        return navigationService;
    }

    /**
     * Navigates to the type specified by the destination view controller
     * @param viewControllerType
     * @param params represents the navigation parameters
     * @param <T> represents the type of the view controller
     */
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
