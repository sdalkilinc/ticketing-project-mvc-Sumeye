package com.cydeo.controller;


import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.ProjectService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {


    private final UserService userService;
    private final ProjectService projectService;

    public ProjectController(UserService userService, ProjectService projectService) {
        this.userService = userService;
        this.projectService = projectService;
    }

    @RequestMapping("/create")
    public String createProject(Model model){

        model.addAttribute("project", new ProjectDTO());

        model.addAttribute("managers", userService.findManagers());

        model.addAttribute("projects", projectService.findAll());

        return "/project/create";
    }

    @PostMapping("/create")
    public String insertProject(@ModelAttribute("project") ProjectDTO project){

        projectService.save(project);

        return "redirect:/project/create";
        //to create this save method, we need to go create.html page first and edit the form button
        //by adding end point and passing the method kind(post or get)
    }

    @GetMapping("/delete/{projectCode}")
    public String deleteProject(@PathVariable("projectCode") String projectCode){

        projectService.deleteById(projectCode);

        return "redirect:/project/create";
    }

    @GetMapping("/complete/{projectCode}")
    public String completeProject(@PathVariable("projectCode") String projectCode){

        projectService.complete(projectService.findById(projectCode));

        return "redirect:/project/create";
    }

//    @PostMapping("/update")
//    public String updateProject(@ModelAttribute("project") ProjectDTO project){
//        //With latest update, we even don't need to put @ModelAttribute("user")
//        //bc springboot is enough smart to understand
//        projectService.update(project);
//
//        return "redirect:/project/create";
//    }

    @GetMapping("/update/{projectCode}")
    public String editProject(@PathVariable("projectCode") String projectCode, Model model){

        model.addAttribute("project", projectService.findById(projectCode));

        model.addAttribute("managers", userService.findManagers());

        model.addAttribute("projects",projectService.findAll());

        return "/project/update";
    }

    @PostMapping("/update")
    public String updateProject(@ModelAttribute("project") ProjectDTO project){
        //With latest update, we even don't need to put @ModelAttribute("project")
        //bc springboot is enough smart to understand
        projectService.update(project);

        return "redirect:/project/create";
    }

    @GetMapping("/manager/project-status")
    public String getProjectByManager(Model model){

        UserDTO manager = userService.findById("john@cydeo.com");

        List<ProjectDTO> projects = projectService.getCountedListOfProjectDTO(manager);

        model.addAttribute("projects", projects);
        return "/manager/project-status";

    }




}
