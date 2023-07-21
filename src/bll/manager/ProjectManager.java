package bll.manager;

import bll.be.Project;
import bll.manager.interfaces.IProjectManager;
import dal.ProjectDAO;
import dal.interfaces.IProjectDAO;

import java.util.List;

public class ProjectManager implements IProjectManager {
    private IProjectDAO projectDAO;
    public ProjectManager(){
        projectDAO = new ProjectDAO();
    }
    @Override
    public List<Project> getAllProjects() {
        return projectDAO.getAllProjects();
    }

    @Override
    public List<Project> getPublicProjects() {
        return projectDAO.getPublicProjects();
    }

    @Override
    public List<Project> getPrivateProjects() {
        return projectDAO.getPrivateProjects();
    }

    @Override
    public Project getProjectByRefNumber(String refNumber) {
        return projectDAO.getProjectByRefNumber(refNumber);
    }

    @Override
    public Project getProjectByCustomerName(String customerName) {
        return projectDAO.getProjectByCustomerName(customerName);
    }

    @Override
    public Project getProjectByLocation(String location) {
        return projectDAO.getProjectByLocation(location);
    }

    @Override
    public Project getProjectByCreationDate(String date) {
        return projectDAO.getProjectByCreationDate(date);
    }

    @Override
    public Project getProjectByStartDate(String date) {
        return projectDAO.getProjectByStartDate(date);
    }

    @Override
    public Project getProjectByEndDate(String date) {
        return projectDAO.getProjectByEndDate(date);
    }

    @Override
    public Boolean createProject(Project project) {
        return projectDAO.createProject(project);
    }

    @Override
    public Boolean updateProject(Project project) {
        return projectDAO.updateProject(project);
    }

    @Override
    public Boolean removeProject(String refNumber) {
        return projectDAO.removeProject(refNumber);
    }
}
