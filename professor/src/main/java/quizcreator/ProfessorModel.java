package main.java.quizcreator;

import dao.Question;
import dao.Quiz;
import json.QuizAccessor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorModel {

    private Quiz quiz = new Quiz();

    public Quiz getQuiz() {
        return this.quiz;
    }

    public ProfessorModel(String quizFileName) {

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
        quiz.questions.add(newQuestion);
    }

}
