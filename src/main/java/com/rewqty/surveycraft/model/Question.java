package com.rewqty.surveycraft.model;

import com.rewqty.surveycraft.enums.TypeQuestion;

import java.util.List;

public class Question {
    private TypeQuestion typeQuestion;

    private String question;

    private List<Answer> answers;

    public Question() {
    }

    public Question(String typeQuestion, String question, List<Answer> answers) {
        this.typeQuestion = TypeQuestion.valueOf(typeQuestion);
        this.question = question;
        this.answers = answers;
    }
    public Question(TypeQuestion typeQuestion, String question, List<Answer> answers) {
        this.typeQuestion = typeQuestion;
        this.question = question;
        this.answers = answers;
    }

    public TypeQuestion getTypeQuestion() {
        return typeQuestion;
    }

    public String getQuestion() {
        return question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
