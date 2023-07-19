package bll.be;

public class Log {
    private int id;
    private int accountID;
    private String refNumber;
    private String date;

    public Log(int id, int accountID, String refNumber, String date){
        this.id = id;
        this.accountID = accountID;
        this.refNumber = refNumber;
        this.date = date;
    }

    public static Log createLog(int accountID, String refNumber, String date){
        return new Log(0, accountID, refNumber, date);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
