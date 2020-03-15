package fzu.gxfj.pojo;

public class Appointment {
    private Integer id;
    private Boolean isWin;
    private Integer appointmentsID;
    private Integer appointmentNum;
    private String userName;
    private String userId;
    private String userPhone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public Integer getAppointmentsID() {
        return appointmentsID;
    }

    public void setAppointmentsID(Integer appointmentsID) {
        this.appointmentsID = appointmentsID;
    }

    public Integer getAppointmentNum() {
        return appointmentNum;
    }

    public void setAppointmentNum(Integer appointmentNum) {
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
