package main.java.quizcreator;

import dto.Question;
import dto.Quiz;
import json.QuizAccessor;

import java.io.IOException;
import java.util.List;

public class QuizCreatorModel {

    private Quiz quiz = new Quiz();

    public Quiz getQuiz() {
        return this.quiz;
    }

    public QuizCreatorModel(String quizFileName) {

    }

    public void exportQuiz(String quizFileName) {
        try
        {
            QuizAccessor.writeQuizToFile(quiz,"Resources/" + quizFileName);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    /**
     * * This method is responsible for saving the details of each question that the professor enters.
     *      * If saves the right answer selected by the professor and loads a new frame
     *      * to add the next question.
     * @param questionTitle
     * @param options
     * @param correctOption
     */
    public void saveQuestion(String questionTitle, List<String> options, String correctOption)
    {
        Question newQuestion = new Question();
        newQuestion.setTitle(questionTitle);
        newQuestion.setOptions(options);
        newQuestion.setCorrectAnswer(correctOption);
        quiz.getQuestions().add(newQuestion);
    }

}
