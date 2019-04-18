package team1.project3.factories;

import team1.project3.service.IModel;
import team1.project3.service.IView;
import team1.project3.service.IViewController;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * Generates the quiz component and initializes with its model and controller
 */
public class UIFactory {
    private static final HashMap<String, String> VIEW_CONTROLLER_TO_VIEW_MAP =
            new HashMap<String, String>(){
                {
                    put("1", "team1.project3.quizlist.QuizListView");
                    put("2", "team1.project3.quiztaker.QuizTakerView");
                }};

    private static final HashMap<String, String> VIEW_CONTROLLER_TO_MODEL_MAP =
            new HashMap<String, String>(){
                {
                    put("1", "team1.project3.quizlist.QuizListModel");
                    put("2", "team1.project3.quiztaker.QuizTakerModel");
                }};

    private static final HashMap<String, String> VIEW_CONTROLLER_TO_VC_MAP =
            new HashMap<String, String>(){
                {
                    put("1", "team1.project3.quizlist.QuizListViewController");
                    put("2", "team1.project3.quiztaker.QuizTakerViewController");
                }};


    /**
     * Generates quiz components
     * @param viewControllerType specifies the {@code class} type of viewcontroller
     * @param params represents the navigation params to initialize the component
     * @return the root UI component
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public static IViewController generateComponent(String viewControllerType, HashMap<String, String> params)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        IModel model  = null;
        IViewController viewController = null;

        try {
            model = (IModel) Class.forName(VIEW_CONTROLLER_TO_MODEL_MAP.get(viewControllerType)).getConstructor().newInstance();

        IView view = (IView) Class.forName(VIEW_CONTROLLER_TO_VIEW_MAP.get(viewControllerType)).getConstructor().newInstance();
         viewController= (IViewController) Class.forName(VIEW_CONTROLLER_TO_VC_MAP.get(viewControllerType)).getConstructor().newInstance();
        viewController.initializeViewController(view, model, params);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return viewController;
    }
}
