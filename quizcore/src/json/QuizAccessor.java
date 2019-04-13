package json;

import dto.Quiz;
import org.apache.commons.io.FileUtils;
import utilities.JsonHelper;
import java.io.*;

/**
 * Helper class to perform read and write operations for Quizzes
 */
public class QuizAccessor {
    /**
     * Reads a file and de-serialize the file contents to json
     * @param filePath specifies the location of the file
     * @return the de-serialized {@code Quiz} object
     * @throws IOException if there is an error in reading file
     */
    public static Quiz readQuizFromFile(String filePath) throws IOException {
        String jsonString = FileUtils.readFileToString(new File(filePath), "UTF-8");
        return JsonHelper.deserialize(jsonString, Quiz.class);
    }

    /**
     * Serializes the {@code Quiz} instance and saves the string to file
     * @param quiz instance to be serialized and saved
     * @param filePath specifies the location of the file
     * @throws IOException if there is an error in writing file
     */
    public static void writeQuizToFile(Quiz quiz, String filePath) throws IOException {
        String jsonString = JsonHelper.serialize(quiz);
        FileUtils.writeStringToFile(new File(filePath), jsonString);
    }
}
