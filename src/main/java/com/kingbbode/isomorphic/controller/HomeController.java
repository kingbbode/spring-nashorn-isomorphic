package com.kingbbode.isomorphic.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kingbbode.isomorphic.handlebars.HandleBarsTemplate;
import com.kingbbode.isomorphic.handlebars.HandlebarsTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by YG on 2016-03-28.
 */

@Controller
public class HomeController {   

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    HandlebarsTemplateService handlebarsTemplateService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) throws Exception {
        model.addAttribute("text", "server");
        model.addAttribute("layer", handlebarsTemplateService.render(new HandleBarsTemplate("layer").put("text", "server")));
        return "index";
    }
}
