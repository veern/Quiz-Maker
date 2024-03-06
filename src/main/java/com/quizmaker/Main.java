package com.quizmaker;

import java.util.ArrayList;
import java.util.Scanner;

import main.java.com.quizmaker.FileRead;

public class Main {
    public static void main(String[] args) {
        FileRead file = new FileRead();
        String path = "";
        ArrayList<String> textFiles = new ArrayList<>();
        Scanner terminalInputScanner = new Scanner(System.in);
        System.out.println("Enter the path where the questions are located:");
        path = terminalInputScanner.nextLine();
        terminalInputScanner.close();
        textFiles = FileRead.listAllFilesInDirectory(path);
        for (String fileName : textFiles) {
            file.read(fileName);
        }
    }
}