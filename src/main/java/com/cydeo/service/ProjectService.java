package com.cydeo.service;

import com.cydeo.dto.ProjectDTO;

public interface ProjectService extends CrudService<ProjectDTO, String>{
    //Crud service is looking 2 things: 1)which object? 2)the unique thing

    void complete(ProjectDTO project);

}
