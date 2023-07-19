package dal;

import bll.be.Project;
import dal.connector.MSSQLConnector;
import dal.interfaces.IProjectDAO;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.List;

public class ProjectDAO implements IProjectDAO {
    private final MSSQLConnector mssqlConnector;
    private PreparedStatement preparedStatement;

    public ProjectDAO(){
        try {
            mssqlConnector = new MSSQLConnector();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Project> getAllProjects() {
        return null;
    }

    @Override
    public List<Project> getPublicProjects() {
        return null;
    }

    @Override
    public List<Project> getPrivateProjects() {
        return null;
    }

    @Override
    public Project getProjectByRefNumber(String refNumber) {
        return null;
    }

    @Override
    public Project getProjectByCustomerName(String customerName) {
        return null;
    }

    @Override
    public Project getProjectByLocation(String location) {
        return null;
    }

    @Override
    public Project getProjectByCreationDate(String date) {
        return null;
    }

    @Override
    public Project getProjectByStartDate(String date) {
        return null;
    }

    @Override
    public Project getProjectByEndDate(String date) {
        return null;
    }

    @Override
    public Boolean createProject(Project project) {
        return null;
    }

    @Override
    public Boolean updateProject(Project project) {
        return null;
    }

    @Override
    public Boolean removeProject(String refNumber) {
        return null;
    }
}
