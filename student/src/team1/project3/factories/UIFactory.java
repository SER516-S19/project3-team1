package team1.project3.factories;

import team1.project3.quizlist.QuizListModel;
import team1.project3.quizlist.QuizListView;
import team1.project3.quizlist.QuizListViewController;
import team1.project3.quiztaker.QuizTakerModel;
import team1.project3.quiztaker.QuizTakerView;
import team1.project3.quiztaker.QuizTakerViewController;
import team1.project3.service.IModel;
import team1.project3.service.IView;
import team1.project3.service.IViewController;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class UIFactory {

    private static final HashMap<Class<?>, Class<?>> VIEW_CONTROLLER_TO_VIEW_MAP =
            new HashMap<Class<?>, Class<?>>(){
                {
                    put(QuizListViewController.class, QuizListView.class);
                    put(QuizTakerViewController.class, QuizTakerView.class);
                }};

    private static final HashMap<Class<?>, Class<?>> VIEW_CONTROLLER_TO_MODEL_MAP =
            new HashMap<Class<?>, Class<?>>(){
                {
                    put(QuizListViewController.class, QuizListModel.class);
                    put(QuizTakerViewController.class, QuizTakerModel.class);
                }};


    public static IViewController generateComponent(Class<?> viewControllerType, HashMap<String, String> params)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        IModel model  = (IModel) VIEW_CONTROLLER_TO_MODEL_MAP.get(viewControllerType).getConstructor().newInstance();
        IView view = (IView) VIEW_CONTROLLER_TO_VIEW_MAP.get(viewControllerType).getConstructor().newInstance();
        IViewController viewController = (IViewController) viewControllerType.getConstructor().newInstance();
        viewController.initializeViewController(view, model, params);

        return viewController;
    }
}
