package team1.project3.quizlist;

import team1.project3.service.IModel;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class QuizListModel implements IModel {
    public QuizListModel() {
    }

    List<String> getQuizNames() {
        List<String> quizNames = new ArrayList<String>();
        File folder = new File("Resources");
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                quizNames.add(file.getName());
            }
        }
        return quizNames;
    }

    public List<String> getQuizNamesWithoutExtension(List<String> quiznames) {
        List<String> quizNamesWithoutExtension = new ArrayList<String>();
        for(String quizName : quiznames){
            int index = quizName.lastIndexOf(".");
            if (index > 0){
                quizNamesWithoutExtension.add(quizName.substring(0, index));
            } else {
                quizNamesWithoutExtension.add(quizName);
            }
        }
        return quizNamesWithoutExtension;
    }


}
