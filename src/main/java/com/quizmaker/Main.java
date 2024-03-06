package com.quizmaker;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileRead file = new FileRead();
        String path = "";
        ArrayList<String> textFiles = new ArrayList<>();
        Question question = new Question();
        Scanner terminalInputScanner = new Scanner(System.in);
        System.out.println("Enter the path where the questions are located:");
        path = terminalInputScanner.nextLine();
        terminalInputScanner.close();
        textFiles = FileRead.listAllFilesInDirectory(path);
        for (int i = 0; i < textFiles.size(); i++) {
            question = file.read(textFiles.get(i));
            question.displayAnswers();
        }
    }
}