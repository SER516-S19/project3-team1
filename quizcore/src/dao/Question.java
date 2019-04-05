package dao;

import java.util.ArrayList;
import java.util.Iterator;

public class Question implements Iterable<String> {
    private String title;
    private ArrayList<String> options;
    private String correct_answer;

    public Question(String title, ArrayList<String> options, String answer) {
        this.title = title;
        this.options = options;
        this.correct_answer = answer;
    }

    public String getTitle() {
        return title;
    }

    public String getOption(int i) {
        return options.get(i);
    }

    public String getCorrectAnswer() {
        return correct_answer;
    }

    @Override
    public Iterator<String> iterator() {
        return options.iterator();
    }
}
