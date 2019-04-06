package main.java.quiz;

import dao.Quiz;
import json.QuizAccessor;

import java.io.IOException;

public class StudentModel {

    private Quiz quiz;

    public Quiz getQuiz() {
        return quiz;
    }

    public StudentModel(String quizFileName) {

        try {
            quiz = QuizAccessor.readQuizFromFile("Resources/"+quizFileName);
            System.out.println(quiz);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

