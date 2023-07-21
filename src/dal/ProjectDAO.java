package dal;

import bll.be.Project;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import dal.connector.MSSQLConnector;
import dal.interfaces.IProjectDAO;
import dal.mapper.ProjectMapper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO implements IProjectDAO {
    private final MSSQLConnector mssqlConnector;
    private PreparedStatement preparedStatement;

    public ProjectDAO() {
        try {
            mssqlConnector = new MSSQLConnector();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Project> getAllProjects() {
        ProjectMapper mapper = new ProjectMapper();
        List<Project> allProjects = new ArrayList<>();

        try {
            Connection conn = mssqlConnector.createConnection();
            String sql = "SELECT * FROM Projects";
            preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                mapper.mapProject(rs);
                allProjects.add(mapper.getProject());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allProjects;
    }

    @Override
    public List<Project> getPublicProjects() {
        ProjectMapper mapper = new ProjectMapper();
        List<Project> allProjects = new ArrayList<>();

        try {
            Connection conn = mssqlConnector.createConnection();
            String sql = "SELECT * FROM Projects WHERE private=?";//TODO look up the column names
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setBoolean(1, false);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                mapper.mapProject(rs);
                allProjects.add(mapper.getProject());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allProjects;
    }

    @Override
    public List<Project> getPrivateProjects() {
        ProjectMapper mapper = new ProjectMapper();
        List<Project> allProjects = new ArrayList<>();

        try {
            Connection conn = mssqlConnector.createConnection();
            String sql = "SELECT * FROM Projects WHERE private=?";//TODO look up the column names
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setBoolean(1, true);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                mapper.mapProject(rs);
                allProjects.add(mapper.getProject());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allProjects;
    }

    @Override
    public Project getProjectByRefNumber(String refNumber) {
        ProjectMapper mapper = new ProjectMapper();
        Project project = null;

        try {
            Connection conn = mssqlConnector.createConnection();
            String sql = "SELECT * FROM Projects WHERE refNumber=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, refNumber);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                mapper.mapProject(rs);
                project = mapper.getProject();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return project;
    }

    @Override
    public Project getProjectByCustomerName(String customerName) {
        ProjectMapper mapper = new ProjectMapper();
        Project project = null;

        try {
            Connection conn = mssqlConnector.createConnection();
            String sql = "SELECT * FROM Projects WHERE customerName=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, customerName);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                mapper.mapProject(rs);
                project = mapper.getProject();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return project;
    }

    @Override
    public Project getProjectByLocation(String location) {
        ProjectMapper mapper = new ProjectMapper();
        Project project = null;

        try {
            Connection conn = mssqlConnector.createConnection();
            String sql = "SELECT * FROM Projects WHERE location=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, location);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                mapper.mapProject(rs);
                project = mapper.getProject();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return project;
    }

    @Override
    public Project getProjectByCreationDate(String date) {
        ProjectMapper mapper = new ProjectMapper();
        Project project = null;

        try {
            Connection conn = mssqlConnector.createConnection();
            String sql = "SELECT * FROM Projects WHERE creationDate=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, date);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                mapper.mapProject(rs);
                project = mapper.getProject();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return project;
    }

    @Override
    public Project getProjectByStartDate(String date) {
        ProjectMapper mapper = new ProjectMapper();
        Project project = null;

        try {
            Connection conn = mssqlConnector.createConnection();
            String sql = "SELECT * FROM Projects WHERE startDate=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, date);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                mapper.mapProject(rs);
                project = mapper.getProject();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return project;
    }

    @Override
    public Project getProjectByEndDate(String date) {
        ProjectMapper mapper = new ProjectMapper();
        Project project = null;

        try {
            Connection conn = mssqlConnector.createConnection();
            String sql = "SELECT * FROM Projects WHERE endDate=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, date);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                mapper.mapProject(rs);
                project = mapper.getProject();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return project;
    }

    @Override
    public Boolean createProject(Project project) {
        try {
            Connection conn = mssqlConnector.createConnection();
            String sql = "INSERT INTO Projects (refNumber, name, email, location, note, drawing, creationDate, " +
                    "startDate, endDate, approved, privateProject, includePictures, includeDrawing) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, project.getRefNumber());
            preparedStatement.setString(2, project.getName());
            preparedStatement.setString(3, project.getEmail());
            preparedStatement.setString(4, project.getLocation());
            preparedStatement.setString(5, project.getNote());
            preparedStatement.setString(6, project.getDrawing());//TODO change later to picture
            preparedStatement.setString(7, project.getCreationDate());
            preparedStatement.setString(8, project.getStartDate());
            preparedStatement.setString(9, project.getEndDate());
            preparedStatement.setBoolean(10, project.getApproved());
            preparedStatement.setBoolean(11, project.getPrivateProject());
            preparedStatement.setBoolean(12, project.getIncludePictures());
            preparedStatement.setBoolean(13, project.getIncludeDrawing());
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public Boolean updateProject(Project project) {
        try {
            Connection conn = mssqlConnector.createConnection();
            String sql = "UPDATE Projects SET name=?, email=?, location=?, note=?, drawing=?," +
                    "creationDate=?, startDate=?, endDate=?, approved=?, privateProject=?, includePictures=?, " +
                    "includeDrawing=? WHERE refNumber=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getEmail());
            preparedStatement.setString(3, project.getLocation());
            preparedStatement.setString(4, project.getNote());
            preparedStatement.setString(5, project.getDrawing());//TODO change later to picture
            preparedStatement.setString(6, project.getCreationDate());
            preparedStatement.setString(7, project.getStartDate());
            preparedStatement.setString(8, project.getEndDate());
            preparedStatement.setBoolean(9, project.getApproved());
            preparedStatement.setBoolean(10, project.getPrivateProject());
            preparedStatement.setBoolean(11, project.getIncludePictures());
            preparedStatement.setBoolean(12, project.getIncludeDrawing());
            preparedStatement.setString(13, project.getRefNumber());
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public Boolean removeProject(String refNumber) {
        try {
            Connection conn = mssqlConnector.createConnection();
            String sql = "DELETE FROM Projects WHERE refNumber=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, refNumber);
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
