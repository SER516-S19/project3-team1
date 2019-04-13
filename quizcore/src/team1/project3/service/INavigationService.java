package team1.project3.service;

import java.util.HashMap;

/**
 * The NavigationService interface
 */
public interface INavigationService {
    /**
     * Navigates to the destination view controller type
     * @param viewController represents the destination view controller
     * @param params represents the navigation parameters
     * @param <T> represents the type of the view controller
     */
    <T> void navigate(Class<T> viewController, HashMap<String, String> params);
}
