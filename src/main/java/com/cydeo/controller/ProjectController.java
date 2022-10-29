package com.cydeo.controller;


import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.UserDTO;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @RequestMapping("/create")
    public String createProject(Model model){

        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("managers", UserDTO user);

        return "/project/create";
    }
}
