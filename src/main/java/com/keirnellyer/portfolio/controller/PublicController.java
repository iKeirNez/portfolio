package com.keirnellyer.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PublicController {
    @RequestMapping
    public String index(Model model) {
        return "templates/index";
    }
}
