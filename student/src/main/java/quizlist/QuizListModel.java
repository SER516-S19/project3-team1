package main.java.quizlist;

import service.IModel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class QuizListModel implements IModel {
    public QuizListModel() {
    }

    private List<String> quizNames = new ArrayList<String>();

    public List<String> getQuizNames() {
        File folder = new File("Resources");
        File[] listOfFiles = folder.listFiles();
        for(int i =0;i<listOfFiles.length;i++){
            quizNames.add(listOfFiles[i].getName().substring(0, listOfFiles[i].getName().indexOf(".")));
        }

        return quizNames;
    }


}
