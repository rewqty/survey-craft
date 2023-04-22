package com.rewqty.surveycraft.model;

public class Survey {
    private String question;
    private String answer;

    public Survey(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
