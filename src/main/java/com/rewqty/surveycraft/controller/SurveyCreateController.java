package com.rewqty.surveycraft.controller;

import com.rewqty.surveycraft.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SurveyCreateController {
    @Autowired
    SurveyService surveyService;

    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String create(Model model) {
        return "createSurvey";
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public String doCreate(@ModelAttribute("question") String question,
                           @ModelAttribute("answer") String answer) {
        surveyService.create(question,answer);
        return "redirect:/";
    }
}
