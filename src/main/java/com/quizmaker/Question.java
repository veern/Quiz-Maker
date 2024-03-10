package com.quizmaker;

import java.util.ArrayList;
import java.util.Collections;

public class Question {

    private String question;
    private ArrayList<String> answers;
    private String correctAnswer;

    public Question(String question, ArrayList<String> answers) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = answers.get(0);
    }

    public Question() {
        this.question = "";
        this.answers = new ArrayList<>();
        this.correctAnswer = "";
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getAnswers() {
        return this.answers;
    }

    public void displayAnswers() {
        randomizeAnswers();
        for (String answer : answers) {
            System.out.println(answer);
        }
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
        this.correctAnswer = this.answers.get(0);
    }

    public String getCorrectAnswer() {
        return this.correctAnswer;
    }

    public String toString() {
        return "Question: " + question + " - answers: " + String.join(", ", answers);
    }

    public void randomizeAnswers() {
        Collections.shuffle(answers);
    }
}
