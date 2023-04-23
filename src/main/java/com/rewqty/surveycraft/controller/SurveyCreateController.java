package com.rewqty.surveycraft.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.rewqty.surveycraft.model.Answer;
import com.rewqty.surveycraft.model.Question;
import com.rewqty.surveycraft.model.Survey;
import com.rewqty.surveycraft.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.fasterxml.jackson.databind.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class SurveyCreateController {
    @Autowired
    SurveyService surveyService;

    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String create(Model model) {
        return "createSurvey";
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public String doCreate(@RequestBody String survey) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        surveyService.create(objectMapper.readValue(survey, Survey.class));
        return "redirect:/";
    }
}
