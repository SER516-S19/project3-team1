package main.java.quiztaker;

import dto.Quiz;
import json.QuizAccessor;
import service.IModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuizTakerModel implements IModel {

    private Quiz quiz;
    private List<Integer> incorrectQuestionsIndex = new ArrayList<Integer>();

    Quiz getQuiz() {
        return quiz;
    }

    public QuizTakerModel() {

    }

    public void loadQuiz(String quizFileName) {

        try {
            quiz = QuizAccessor.readQuizFromFile("Resources/" + quizFileName);
            System.out.println(quiz);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is responsible for evaluating each question attempted in the quiztaker.
     * If the answer selected by user is incorrect, it adds the question's index to a list of incorrect questions.
     *
     * @param currentQuestionIndex
     * @param selectedOptionIndex
     */
    public void evaluateAnswer(int currentQuestionIndex, int selectedOptionIndex) {

        if (quiz.getQuestions().get(currentQuestionIndex).getCorrectAnswer()
                != quiz.getQuestions().get(currentQuestionIndex).getOptions().get(selectedOptionIndex))
            incorrectQuestionsIndex.add(currentQuestionIndex);
    }

}

