package dal.mapper;

import bll.be.Project;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectMapper {
    private Project project;

    public ProjectMapper() {
        this.project = null;
    }

    public void mapProject(ResultSet rs) throws SQLException {
        String refNumber = rs.getString("refNumber");
        String name = rs.getString("customerName");
        String email = rs.getString("customerEmail");
        String location = rs.getString("customerLocation");
        String note = rs.getString("note");
        String drawing = rs.getString("drawing");
        String creationDate = rs.getString("creationDate");
        String startDate = rs.getString("startDate");
        String endDate = rs.getString("endDate");
        Boolean approved = rs.getBoolean("approved");
        Boolean privateProject = rs.getBoolean("privateProject");
        Boolean includePictures = rs.getBoolean("includePictures");
        Boolean includeDrawing = rs.getBoolean("includeDrawing");

        this.project = new Project(refNumber,name,email,location,note,drawing,creationDate,startDate,endDate,approved,
                privateProject,includePictures,includeDrawing);
    }

    public Project getProject(){
        return this.project;
    }
}
