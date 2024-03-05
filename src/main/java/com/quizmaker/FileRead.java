package main.java.com.quizmaker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileRead {
    public void read(String fileName) {
        try {
            File myFile = new File(fileName);
            Scanner myScanner = new Scanner(myFile);
            while ( myScanner.hasNextLine() ) {
                String data = myScanner.nextLine();
                System.out.println(data);
            myScanner.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file with given name.");
            e.printStackTrace();
        }
    }
}
