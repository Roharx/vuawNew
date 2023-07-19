package bll.be;

public class Project {
    private String refNumber;
    private String name;
    private String email;
    private String location;
    private String note;
    private String drawing;
    private String creationDate;
    private String startDate;
    private String endDate;
    private Boolean approved;
    private Boolean privateProject;
    private Boolean includePictures;
    private Boolean includeDrawing;

    public Project(String refNumber, String name, String email, String location, String note,
                   String drawing, String creationDate, String startDate, String endDate, Boolean approved,
                   Boolean privateProject, Boolean includePictures, Boolean includeDrawing) {

        this.refNumber = refNumber;
        this.name = name;
        this.email = email;
        this.location = location;
        this.note = note;
        this.drawing = drawing;
        this.creationDate = creationDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.approved = approved;
        this.privateProject = privateProject;
        this.includePictures = includePictures;
        this.includeDrawing = includeDrawing;
    }

    public static Project createProject(String name, String email, String location, String note,
                                        String drawing, String creationDate, String startDate, String endDate,
                                        Boolean approved, Boolean privateProject, Boolean includePictures,
                                        Boolean includeDrawing) {

        return new Project(null, name, email, location, note, drawing, creationDate, startDate, endDate,
                approved, privateProject, includePictures, includeDrawing);
    }

    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String customerName) {
        this.name = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String customerEmail) {
        this.email = customerEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String customerLocation) {
        this.location = customerLocation;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDrawing() {
        return drawing;
    }

    public void setDrawing(String drawing) {
        this.drawing = drawing;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Boolean getPrivateProject() {
        return privateProject;
    }

    public void setPrivateProject(Boolean privateProject) {
        this.privateProject = privateProject;
    }

    public Boolean getIncludePictures() {
        return includePictures;
    }

    public void setIncludePictures(Boolean includePictures) {
        this.includePictures = includePictures;
    }

    public Boolean getIncludeDrawing() {
        return includeDrawing;
    }

    public void setIncludeDrawing(Boolean includeDrawing) {
        this.includeDrawing = includeDrawing;
    }
}
