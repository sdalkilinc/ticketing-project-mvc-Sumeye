package com.cydeo.controller;


import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @RequestMapping("/create")
    public String createProject(){

        return "/project/create";
    }
}
