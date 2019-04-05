package com.team1.project3.quizdao;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.*;
import java.util.ArrayList;

public class QuizAccessor {
    public static Quiz OpenQuiz(String filepath) throws IOException {
        OpenQuiz(new File(filepath));
    }

    public static Quiz OpenQuiz(File file) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        Quiz quiz = new Quiz(file.getName());
        try {
            return parse_quiz(quiz, reader);
        } finally {
            reader.close();
        }
    }

    private static Quiz parse_quiz(Quiz quiz, JsonReader reader) throws IOException {
        reader.beginObject();
        if(reader.nextName().equals("Questions")) {
            reader.beginArray();
            while(reader.hasNext()) {
                quiz.addQuestion(parse_question(reader));
            }
        } else {
            //TODO: malformed quiz
        }
        reader.endObject();
        return quiz;
    }

    private static Question parse_question(JsonReader reader) throws IOException {
        String title = "";
        ArrayList<String> options = new ArrayList<String>();
        String answer = "";

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("title")) {
                title = reader.nextString();
            } else if (name.equals("options")) {
                reader.beginArray();
                while(reader.hasNext()) {
                    options.add(reader.nextString());
                }
                reader.endArray();
            } else if (name.equals("correctAnswer")) {
                answer = reader.nextString();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new Question(title, options, answer);
    }

    public static Quiz OpenQuiz(String filepath, Quiz quiz) throws IOException {
        OpenQuiz(new File(filepath), quiz);
    }

    public static void SaveQuiz(File file, Quiz quiz) throws IOException {
        JsonWriter writer = new JsonWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
        writer.setIndent("    ");
        writer.beginObject();
        writer.name("questions").beginArray();
        for (Question q : quiz) {
            writer.beginObject();
            writer.name("title").value(q.getTitle());
            writer.name("options").beginArray();
            for (String option : q) {
                writer.value(option);
            }
            writer.endArray();
        }
        writer.endArray();
        writer.close();
    }
}
