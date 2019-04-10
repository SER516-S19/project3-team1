package json;

import dto.Quiz;
import org.apache.commons.io.FileUtils;
import utilities.JsonHelper;

import java.io.*;

public class QuizAccessor {

    public static Quiz readQuizFromFile(String filePath) throws IOException {
        String jsonString = FileUtils.readFileToString(new File(filePath), "UTF-8");
        return JsonHelper.deserialize(jsonString, Quiz.class);
    }

    public static void writeQuizToFile(Quiz quiz, String filePath) throws IOException {
        String jsonString = JsonHelper.serialize(quiz);
        FileUtils.writeStringToFile(new File(filePath), jsonString);
    }

}
