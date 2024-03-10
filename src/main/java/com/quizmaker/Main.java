package com.quizmaker;

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.readFiles();
        quiz.loopThroughQuestions();
    }
}