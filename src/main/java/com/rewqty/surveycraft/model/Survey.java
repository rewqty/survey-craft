package com.rewqty.surveycraft.model;

import java.util.List;

public class Survey {
    private Long id;
    private String title;
    private List<Question> questions;

    public Survey(){}

    public Survey(Long id, String title, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.questions = questions;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
