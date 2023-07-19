package bll.be;

public class Device {
    private int id;
    private String name;
    private String username;
    private String password;
    private String refNumber;

    public Device(int id, String name, String username, String password, String refNumber) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.refNumber = refNumber;
    }

    public static Device createDevice(String name, String username, String password, String refNumber) {
        return new Device(0, name, username, password, refNumber);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }
}
