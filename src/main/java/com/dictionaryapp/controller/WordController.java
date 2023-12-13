package com.dictionaryapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WordController {


    @GetMapping("/words/add")
    public ModelAndView addWord(){

        return new ModelAndView("word-add");
    }



}
