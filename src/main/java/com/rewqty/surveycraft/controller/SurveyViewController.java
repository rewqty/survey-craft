package com.rewqty.surveycraft.controller;

import com.rewqty.surveycraft.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SurveyViewController {
    @Autowired
    SurveyService surveyService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("appName", "Сентябрь горит");
        model.addAttribute("questions", surveyService.getAllQuestions());
        return "survey";
    }

    @ResponseBody
    @RequestMapping(path = "/survey/{id}", method = RequestMethod.GET)
    public String single(@PathVariable("id") Long id) {
        return "Здесь будет страница опроса №" + id;
    }
}
