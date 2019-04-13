package team1.project3;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import team1.project3.dto.Quiz;

import java.io.*;

public class QuizFactory {

    public static Quiz readQuizFromFile(String filePath) throws IOException {
        String jsonString = FileUtils.readFileToString(new File(filePath), "UTF-8");

        return new Gson().fromJson(jsonString, Quiz.class);
    }

    public static void writeQuizToFile(Quiz quiz, String filePath) throws IOException {
        String jsonString = new GsonBuilder().create().toJson(quiz);

        FileUtils.writeStringToFile(new File(filePath), jsonString);
    }

}
