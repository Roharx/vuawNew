package dal.interfaces;

import bll.be.Project;

import java.util.List;

public interface IProjectDAO {
    List<Project> getAllProjects();
    List<Project> getPublicProjects();
    List<Project> getPrivateProjects();
    Project getProjectByRefNumber(String refNumber);
    Project getProjectByCustomerName(String customerName);
    Project getProjectByLocation(String location);
    Project getProjectByCreationDate(String date);
    Project getProjectByStartDate(String date);
    Project getProjectByEndDate(String date);
    Boolean createProject(Project project);
    Boolean updateProject(Project project);
    Boolean removeProject(String refNumber);
}
