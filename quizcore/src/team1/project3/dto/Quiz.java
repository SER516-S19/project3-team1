package team1.project3.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Quiz} class represents the DTO for a quiz
 */
public class Quiz {
    private List<Question> questions;

    public Quiz() {
        questions = new ArrayList<Question>();
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}


