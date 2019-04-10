package main.java.factories;

import main.java.quizlist.QuizListModel;
import main.java.quizlist.QuizListView;
import main.java.quizlist.QuizListViewController;
import main.java.quiztaker.QuizTakerModel;
import main.java.quiztaker.QuizTakerView;
import main.java.quiztaker.QuizTakerViewController;
import service.IModel;
import service.IView;
import service.IViewController;

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
