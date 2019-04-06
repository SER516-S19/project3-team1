import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import dao.Quiz;
import json.QuizAccessor;

public class StudentModel {
    private static Quiz quiz;
    List<Integer> incorrectQuestionsIndex = new ArrayList<Integer>();

    public StudentModel(String quizFileName) {

        try {
            quiz = QuizAccessor.readQuizFromFile("Resources/" + quizFileName);
            System.out.println(quiz);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is responsible for evaluating each question attempted in the quiz.
     * If the answer selected by user is incorrect, it adds the question's index to a list of incorrect questions.
     *
     * @param currentQuestionIndex
     * @param selectedOptionIndex
     */
    public void evaluateAnswer(int currentQuestionIndex, int selectedOptionIndex) {

        if (quiz.questions.get(currentQuestionIndex).getCorrectAnswer()
                != quiz.questions.get(currentQuestionIndex).getOptions().get(selectedOptionIndex))
            incorrectQuestionsIndex.add(currentQuestionIndex);
    }
}
