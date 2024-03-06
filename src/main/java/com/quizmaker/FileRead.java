package com.quizmaker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileRead {
    public Question read(String fileName) {
        Question fullQuestion = new Question();
        try {
            File myFile = new File(fileName);
            Scanner myScanner = new Scanner(myFile);
            String question = myScanner.nextLine();
            ArrayList<String> answers = new ArrayList<>();
            while (myScanner.hasNextLine()) {
                answers.add(myScanner.nextLine());
            }
            fullQuestion.setFullQuestion(question, answers);
            myScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file with given name.");
            e.printStackTrace();
        }
        return fullQuestion;
    }

    public static ArrayList<String> listAllFilesInDirectory(String path) throws NullPointerException {
        ArrayList<String> listOfFiles = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        File directoryPath = new File(path);
        String[] filesInDirectory = directoryPath.list();
        for (int i = 0; i < filesInDirectory.length; i++) {
            str.setLength(0);
            if (filesInDirectory[i].contains(".txt")) {
                str.append(directoryPath + "\\" + filesInDirectory[i]);
                listOfFiles.add(str.toString());
            }
        }
        return listOfFiles;
    }
}
