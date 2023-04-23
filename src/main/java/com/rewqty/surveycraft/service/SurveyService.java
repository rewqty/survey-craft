package com.rewqty.surveycraft.service;

import com.rewqty.surveycraft.model.Answer;
import com.rewqty.surveycraft.model.Question;
import com.rewqty.surveycraft.model.Survey;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.rewqty.surveycraft.enums.TypeQuestion;

@Service
public class SurveyService {
    private List<Survey> listSurveys = new ArrayList<>(
            Arrays.asList(
                    new Survey(null, "First",
                            Arrays.asList(new Question(TypeQuestion.MANY, "Wow",
                                    Arrays.asList(new Answer()))
                            )
                    ),
                    new Survey(null, "Second",
                            Arrays.asList(
                                    new Question(TypeQuestion.SINGLE, "How use this shit shit",
                                            Arrays.asList(new Answer("I don`t know"))),
                                    new Question(TypeQuestion.SINGLE, "Maybe this is work",
                                            Arrays.asList(
                                                    new Answer("Что-то многовато вложенности"),
                                                    new Answer("Реально, как-то тяжело")))
                            )
                    )
            )
    );
    public List<Survey> getAllSurveys() {
        return listSurveys;
    }

    public void create(String title, List<Question> questions) {
        listSurveys.add(new Survey(null, title, questions));
    }

    public void create(Survey survey) {
        listSurveys.add(survey);
    }
}
