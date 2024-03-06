package main.java.com.quizmaker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileRead {
    public void read(String fileName) {
        try {
            File myFile = new File(fileName);
            Scanner myScanner = new Scanner(myFile);
            while (myScanner.hasNextLine()) {
                String data = myScanner.nextLine();
                System.out.println(data);
            }
            myScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file with given name.");
            e.printStackTrace();
        }
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
