package pl.model;

import bll.be.Project;
import bll.manager.ProjectManager;

import java.util.List;

public class ProjectModel {
    //TODO ProjectManager
    private ProjectManager projectManager;

    public ProjectModel(){
        projectManager = new ProjectManager();
    }

    List<Project> getAllProjects(){
        return projectManager.getAllProjects();
    }
    List<Project> getPublicProjects(){
        return projectManager.getPublicProjects();
    }
    List<Project> getPrivateProjects(){
        return projectManager.getPrivateProjects();
    }
    Project getProjectByRefNumber(String refNumber){
        return projectManager.getProjectByRefNumber(refNumber);
    }
    Project getProjectByCustomerName(String customerName){
        return projectManager.getProjectByCustomerName(customerName);
    }
    Project getProjectByLocation(String location){
        return projectManager.getProjectByLocation(location);
    }
    Project getProjectByCreationDate(String date){
        return projectManager.getProjectByCreationDate(date);
    }
    Project getProjectByStartDate(String date){
        return projectManager.getProjectByStartDate(date);
    }
    Project getProjectByEndDate(String date){
        return projectManager.getProjectByEndDate(date);
    }
    Boolean createProject(Project project){
        return projectManager.createProject(project);
    }
    Boolean updateProject(Project project){
        return projectManager.updateProject(project);
    }
    Boolean removeProject(String refNumber){
        return projectManager.removeProject(refNumber);
    }
}
