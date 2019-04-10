package service;

import java.util.HashMap;

/**
 * The NavigationService interface
 */
public interface INavigationService {

    <T> void navigate(Class<T> viewController, HashMap<String, String> params);
}
