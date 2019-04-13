package team1.project3.quizcreator;

import team1.project3.dto.Question;
import team1.project3.dto.Quiz;

import java.util.List;

/**
 * The {@code QuizCreatorModel} represents the model for the {@code QuizCreatorView}
 */
public class QuizCreatorModel {

    private Quiz quiz = new Quiz();

    Quiz getQuiz() {
        return this.quiz;
    }

    void saveQuestion(String questionTitle, List<String> options, String correctOption) {
        Question newQuestion = new Question();
        newQuestion.setTitle(questionTitle);
        newQuestion.setOptions(options);
        newQuestion.setCorrectAnswer(correctOption);
        quiz.getQuestions().add(newQuestion);
    }

}
