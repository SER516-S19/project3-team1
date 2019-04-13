package team1.project3.quiztaker;

import team1.project3.dto.Quiz;
import team1.project3.dto.Question;
import team1.project3.service.IModel;
import team1.project3.QuizFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the model class for the QuizTaker
 */
public class QuizTakerModel implements IModel {

    private Quiz quiz;
    private List<Integer> incorrectQuestionsIndex = new ArrayList<Integer>();

    Quiz getQuiz() {
        return quiz;
    }

    /**
     * Constructor with no parameters to create instance through {@code UIFactory}
     */
    public QuizTakerModel() {
    }

    List<Integer> getIncorrectQuestionsIndex() {
        return incorrectQuestionsIndex;
    }

    void loadQuiz(String quizFileName) {
        try {
            quiz = QuizFactory.readQuizFromFile("Resources/" + quizFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is responsible for evaluating each question attempted in the quiz.
     * If the answer selected by user is incorrect, it adds the question's index to a list of incorrect questions.
     * @param currentQuestionIndex
     * @param selectedOptionIndex
     */
    void evaluateAnswer(int currentQuestionIndex, int selectedOptionIndex) {
        if(selectedOptionIndex == -1){
            if(!incorrectQuestionsIndex.contains(currentQuestionIndex))
                incorrectQuestionsIndex.add(currentQuestionIndex);
            return;
        }
        if (!quiz.getQuestions().get(currentQuestionIndex).getCorrectAnswer()
                .equals(quiz.getQuestions().get(currentQuestionIndex).getOptions().get(selectedOptionIndex))){
            if(!incorrectQuestionsIndex.contains(currentQuestionIndex)) {
                incorrectQuestionsIndex.add(currentQuestionIndex);
            }
        }

    }

    void prepareQuizWithIncorrectAnswers(){
        List<Question> questionList = new ArrayList<Question>() ;
        List<Integer> incorrectIndexes = this.getIncorrectQuestionsIndex();
        int eachQuestionIndex;
        for(eachQuestionIndex=0;eachQuestionIndex  < incorrectIndexes.size() ; eachQuestionIndex++){
            questionList.add(quiz.getQuestions().get(incorrectIndexes.get(eachQuestionIndex)));
        }
        quiz.setQuestions(questionList);
        this.incorrectQuestionsIndex.clear();
    }

}

