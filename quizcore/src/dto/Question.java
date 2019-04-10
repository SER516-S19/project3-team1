package dto;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Question} class represents the DTO for a quiz question
 */
public class Question {

    private String title;
    private List<String> options;
    private String correctAnswer;

    public Question() {
        options = new ArrayList<String>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
