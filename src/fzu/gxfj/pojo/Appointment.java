package fzu.gxfj.pojo;

public class Appointment {
    private int id;
    private boolean isWin;
    private int appointmentsID;
    private int appointmentNum;
    private String userName;
    private String userId;
    private String userPhone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public int getAppointmentsID() {
        return appointmentsID;
    }

    public void setAppointmentsID(int appointmentsID) {
        this.appointmentsID = appointmentsID;
    }

    public int getAppointmentNum() {
        return appointmentNum;
    }

    public void setAppointmentNum(int appointmentNum) {
        this.appointmentNum = appointmentNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
