package bll.be;

public class Account {
    private int id;
    private String userName;
    private String password;
    private UserType accountType;

    public Account(int id, String userName, String password, UserType accountType) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.accountType = accountType;
    }

    public static Account createAccount(String userName, String password, UserType accountType) {
        return new Account(0, userName, password, accountType);
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public UserType getAccountType() {
        return accountType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountType(UserType accountType) {
        this.accountType = accountType;
    }
}
