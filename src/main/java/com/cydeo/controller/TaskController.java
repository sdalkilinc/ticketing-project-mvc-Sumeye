package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {

    @RequestMapping("/create")
    public String createTask(Model model){


        return "task/create";
    }


}
