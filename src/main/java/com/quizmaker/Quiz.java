package com.quizmaker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Quiz {

    ArrayList<Question> questions = new ArrayList<>();

    public void readFiles() {
        FileReader file = new FileReader();
        String path = "";
        ArrayList<String> textFiles = new ArrayList<>();
        Integer repetitions = 0;
        ArrayList<Question> questions = new ArrayList<>();
        Scanner terminalInputScanner = new Scanner(System.in);
        path = "C:\\Users\\kgumu\\Desktop\\JavaProjectLearning\\Quiz-Maker\\src\\main\\resources";
        // System.out.println("Enter the path where the questions are located.");
        // path = terminalInputScanner.nextLine();
        // System.out.println("How many repetitions per questions?");
        // repetitions = Integer.parseInt(terminalInputScanner.nextLine());
        repetitions = 3;
        textFiles = FileReader.listAllFilesInDirectory(path);
        for (int i = 0; i < textFiles.size(); i++) {
            questions.add(file.read(textFiles.get(i)));
            addExtraQuestions(questions, repetitions, file.read(textFiles.get(i)));
        }
        this.questions = questions;
    }

    public void addExtraQuestions(ArrayList<Question> fullQuestions, Integer amountOfQuestions, Question question) {
        for (int i = 0; i < amountOfQuestions; i++) {
            fullQuestions.add(question);
        }
    }
    
    private void printAllQuestions() {
        for (Question quest : this.questions) {
            System.out.println(quest);
        }
    }

    public int getAmountOfQuestion(Question question) {
        int amt = 0;
        for ( Question quest : this.questions ) {
            if ( quest.getQuestion().equals(question.getQuestion() ) ) {
                amt++;
            }
        }
        return amt;
    }

    public void loopThroughQuestions() {
        Scanner scn = new Scanner(System.in);
        for (int i = 0; i < this.questions.size();) {
            Collections.shuffle(this.questions);
            Question quest = this.questions.get(i);
            printAllQuestions();
            String answer = "";
            System.out.println(
                    "Question: " + quest.getQuestion() + "     DEBUG: correct answer is " + quest.getCorrectAnswer());
            System.out.println("Remaining occurences of this question: " + getAmountOfQuestion(quest));
            System.out.println("Available answers: ");
            quest.displayAnswers();
            answer = scn.nextLine();
            if (Integer.parseInt(answer) == Integer.parseInt(quest.getCorrectAnswer())) {
                this.questions.remove(i);
                System.out.println("Removed");
            }
            else {
                addExtraQuestions(this.questions, 3, quest);
                System.out.println("Added");
            }
        }
        scn.close();
    }
}
