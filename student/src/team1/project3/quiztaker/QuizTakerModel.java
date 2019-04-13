package team1.project3.quiztaker;

import team1.project3.QuizFactory;
import team1.project3.dto.Question;
import team1.project3.dto.Quiz;
import team1.project3.service.IModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuizTakerModel implements IModel {

    private Quiz quiz;
    private List<Integer> incorrectQuestionsIndex = new ArrayList<Integer>();

    public List<Integer> getIncorrectQuestionsIndex() {
        return incorrectQuestionsIndex;
    }

    Quiz getQuiz() {
        return quiz;
    }

    public QuizTakerModel() {

    }

    public void loadQuiz(String quizFileName) {

        try {
            quiz = QuizFactory.readQuizFromFile("Resources/" + quizFileName);
            System.out.println(quiz);
        }
        catch (IOException e) {
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

        if(selectedOptionIndex == -1){
            if(!incorrectQuestionsIndex.contains(currentQuestionIndex))
                incorrectQuestionsIndex.add(currentQuestionIndex);
            return;
        }

        if (!quiz.getQuestions().get(currentQuestionIndex).getCorrectAnswer()
                .equals(quiz.getQuestions().get(currentQuestionIndex).getOptions().get(selectedOptionIndex)))
            if(!incorrectQuestionsIndex.contains(currentQuestionIndex))
                incorrectQuestionsIndex.add(currentQuestionIndex);
    }

    public void prepareQuizWithIncorrectAnswers(){

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

