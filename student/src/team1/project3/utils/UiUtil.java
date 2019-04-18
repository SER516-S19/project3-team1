package team1.project3.utils;

import team1.project3.factories.UIFactory;
import team1.project3.service.IViewController;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class UiUtil {

    public static IViewController getUIComponent(String viewControllerType, HashMap<String, String> params) {
        IViewController viewController = null;
        try {
            viewController = UIFactory.generateComponent(viewControllerType, params);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return viewController;
    }
}
