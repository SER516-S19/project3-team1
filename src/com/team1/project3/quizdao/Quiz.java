package com.team1.project3.quizdao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Quiz implements Iterable<Question> {
    private List<Question> questionList;
    private String title;

    public Quiz(String name) {
        questionList = new LinkedList<Question>();
        this.title = name;
    }

    void addQuestion(Question new_question) {
        questionList.add(new_question);
    }

    Question getQuestion(int index) {
        return questionList.get(index);
    }

    int getQuestionCount() {
        return questionList.size();
    }

    @Override
    public Iterator<Question> iterator() {
        return questionList.iterator();
    }

    public String getTitle() {
        return title;
    }
}


