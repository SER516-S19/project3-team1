import dao.Quiz;
import json.QuizAccessor;

import java.io.IOException;

public class ProfessorModel {

    private static Quiz quiz;

    public ProfessorModel(String quizFileName) {

        try {
            quiz = QuizAccessor.readQuizFromFile("Resources/"+quizFileName);
            System.out.println(quiz);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
