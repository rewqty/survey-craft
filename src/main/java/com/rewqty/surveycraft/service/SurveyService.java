package com.rewqty.surveycraft.service;

import com.rewqty.surveycraft.model.Survey;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SurveyService {
    private ArrayList<Survey> listQuestions = new ArrayList<>(
            Arrays.asList(
                    new Survey("Why?", "Ok"),
                    new Survey("What?", "Because you can do it"),
                    new Survey("Where?", "nineteen o'clock")
            )
    );
    public ArrayList<Survey> getAllQuestions() {
        return listQuestions;
    }

    public void create(String question, String answer) {
        listQuestions.add(new Survey(question, answer));
    }
}
