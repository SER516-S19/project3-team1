package team1.project3.factories;

import org.apache.commons.io.FileUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import team1.project3.dto.Quiz;
import java.io.File;
import java.io.IOException;

/**
 * Helper class to perform read and write operations for Quizzes
 */
public class QuizFactory {
    /**
     * Reads a file and de-serialize the file contents to json
     * @param filePath specifies the location of the file
     * @return the de-serialized {@code Quiz} object
     * @throws IOException if there is an error in reading file
     */
    public static Quiz readQuizFromFile(String filePath) throws IOException {
        String jsonString = FileUtils.readFileToString(new File(filePath), "UTF-8");

        return new Gson().fromJson(jsonString, Quiz.class);
    }

    /**
     * Serializes the {@code Quiz} instance and saves the string to file
     * @param quiz instance to be serialized and saved
     * @param filePath specifies the location of the file
     * @throws IOException if there is an error in writing file
     */
    public static void writeQuizToFile(Quiz quiz, String filePath) throws IOException {
        String jsonString = new GsonBuilder().create().toJson(quiz);
        FileUtils.writeStringToFile(new File(filePath), jsonString);
    }
}