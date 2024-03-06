package com.quizmaker;

import java.util.ArrayList;

public class Question {

    private String question;
    private ArrayList<String> answers;

    public Question(String question, ArrayList<String> answers) {
        this.question = question;
        this.answers = answers;
    }

    public Question() {
        this.question = "";
        this.answers = new ArrayList<>();
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

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public void setFullQuestion(String question, ArrayList<String> answers) {
        setQuestion(question);
        setAnswers(answers);
    }

    public String toString() {
        return "Question: " + question + " - answers: " + String.join(", ", answers);
    }
}
